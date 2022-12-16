package com.victortello.controllers;

import java.io.IOException;
import java.util.Optional;

import com.victortello.models.Carro;
import com.victortello.models.ItemCarro;
import com.victortello.models.Producto;
import com.victortello.services.ProductoService;
import com.victortello.services.ProductoServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/carro/agregar")
public class AgregarCarroServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Long id = Long.parseLong(req.getParameter("id"));
        ProductoService productoService = new ProductoServiceImpl();
        Optional<Producto> producto = productoService.findById(id);

        if (producto.isPresent()) {
            ItemCarro itemCarro = new ItemCarro(1, producto.get());
            HttpSession session = req.getSession();
            Carro carro = (Carro) session.getAttribute("carro");
            carro.addItemCarro(itemCarro);
        }

        resp.sendRedirect(req.getContextPath() + "/carro/ver");
    }

}
