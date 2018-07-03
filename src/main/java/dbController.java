import pba.cxn.dbReader.DbReader;
import pba.cxn.dbReader.DbResultSet;
import pba.logger.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class dbController extends HttpServlet {
    private static String pk;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ContextInitializer.initialize();


        //procesez cererea primita
        pk = req.getParameter("pk");
        if (pk == null)
        {
            resp.getWriter().println("No pk provided");
            return;
        }
        String type = req.getParameter("type");
        if(type != null) {
            switch (type) {
                case "getTEST":
                    resp.getWriter().print("Success!");
                    return;
                case "get" :
                    get(req,resp);
                    break;
                case "update" :
                    update(req,resp);
                    break;
                case "insert" :
                    insert(req,resp);
                    break;
                case "delete" :
                    delete(req,resp);
                    break;
            }
        }
        else {
            resp.getWriter().println("No options provided");
        }

    }

    private void get(HttpServletRequest req, HttpServletResponse resp) {
        try {
        DbResultSet rs = DbReader.poolExecution("SELECT value FROM public.tabel1 WHERE pk=" + pk);

        if(rs.getRowCount() == 0) {
            // return ca nu sunt randuri
            resp.getWriter().println("The querry did not return any rows!");
            return;
        }

        /*
        for (DbRow row : rs) {
            Logger.info(this.getClass(), "Name: " + row.getString(1));
        }
        */

        String value = rs.First().getString(1);
        Logger.info(this.getClass(), "Name: " + value);
        resp.getWriter().println("The value associated with pk: "+pk+" is: "+value);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void update(HttpServletRequest req, HttpServletResponse resp){
        try {
            String value = req.getParameter("value");

            int rowA = DbReader.poolUpdate("UPDATE public.tabel1  set value='" + value + "' WHERE pk=" + pk);
            if (rowA == 0) {
                // Nu am gasit sa fac update
                resp.getWriter().println("The update failed!");

            } else {
                // A mers bine
                resp.getWriter().println("The row with pk: " + pk + " was successfully updated with value: " + value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void insert(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String value = req.getParameter("value");

            int rowA = DbReader.poolUpdate("INSERT INTO public.tabel1 (pk, value) VALUES (" + pk + ", '" + value + "')");
            if (rowA == 0) {
                // Nu am gasit sa fac update
                resp.getWriter().println("The insert failed!");

            } else {
                // A mers bine
                resp.getWriter().println("The row with pk: " + pk + " and value " + value + " was successfully inserted!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) {
        try {
            int rowA = DbReader.poolUpdate("DELETE FROM public.tabel1 WHERE pk = "+pk);
            if (rowA == 0) {
                // Nu am gasit sa fac update
                resp.getWriter().println("The delete operation failed!");

            } else {
                // A mers bine
                resp.getWriter().println("The row with pk: " + pk + " was successfully deleted!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
