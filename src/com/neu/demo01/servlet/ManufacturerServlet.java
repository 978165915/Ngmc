package com.neu.demo01.servlet;

import com.neu.demo01.biz.ManufacturerBiz;
import com.neu.demo01.biz.impl.ManufacturerBizImpl;
import com.neu.demo01.entity.Manufacturer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ManufacturerServlet")
public class ManufacturerServlet extends HttpServlet {
    public ManufacturerServlet() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        ManufacturerBiz manufacturerbiz = new ManufacturerBizImpl();

        if (method.equals("add")) {
            String name_en = request.getParameter("name_en");
            String name_cn = request.getParameter("name_cn");
            String gmc_report_type = request.getParameter("gmc_report_type");
            String gmc_report_url = request.getParameter("gmc_report_url");
            String description = request.getParameter("description");
            Manufacturer manufacturer = new Manufacturer(name_en, name_cn, gmc_report_type, gmc_report_url, description, "1");
            if (manufacturerbiz.save(manufacturer) > 0) {
                response.sendRedirect(request.getContextPath() + "/brand-brandInput.html");
            } else {
                response.sendRedirect(request.getContextPath() + "/brand-addbrand.html");
            }
        }
    }
}