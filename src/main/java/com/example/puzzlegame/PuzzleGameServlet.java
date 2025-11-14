package com.example.puzzlegame;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "PuzzleGameServlet", urlPatterns = {"/game"})
public class PuzzleGameServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html lang='en'>");
            out.println("<head>");
            out.println("    <meta charset='UTF-8'>");
            out.println("    <title>Simple Puzzle Game</title>");
            out.println("    <style>");
            out.println("        body { font-family: sans-serif; text-align: center; margin-top: 40px; }");
            out.println("        .grid { display: inline-grid; grid-template-columns: repeat(3, 60px); gap: 8px; }");
            out.println("        .cell { width: 60px; height: 60px; display:flex; align-items:center; justify-content:center; border:1px solid #444; cursor:pointer; }");
            out.println("        .empty { background:#eee; cursor:default; }");
            out.println("    </style>");
            out.println("</head>");
            out.println("<body>");
            out.println("    <h1>Simple Puzzle Game</h1>");
            out.println("    <p>This is a minimal 3x3 sliding puzzle mockup. In a real version you could add JavaScript to move tiles.</p>");
            out.println("    <div class='grid'>");
            out.println("        <div class='cell'>1</div>");
            out.println("        <div class='cell'>2</div>");
            out.println("        <div class='cell'>3</div>");
            out.println("        <div class='cell'>4</div>");
            out.println("        <div class='cell'>5</div>");
            out.println("        <div class='cell'>6</div>");
            out.println("        <div class='cell'>7</div>");
            out.println("        <div class='cell'>8</div>");
            out.println("        <div class='cell empty'></div>");
            out.println("    </div>");
            out.println("    <p><a href='index.jsp'>Back to home</a></p>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
