/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Excepciones.clienteExistente;
import Excepciones.clienteNoExistente;
import Excepciones.empleadoExistente;
import Excepciones.lineaFacturaExistente;
import Excepciones.productoExistente;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImage;
import com.itextpdf.text.pdf.PdfIndirectObject;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Cliente;
import modelo.Empleado;
import modelo.EmpleadoAdmin;
import modelo.EmpleadoNormal;
import modelo.Factura;
import modelo.LineaFactura;
import modelo.MetodoPago;
import modelo.Ordenador;
import modelo.Pieza;
import modelo.Producto;
import modelo.Servicio;
import modelo.Tienda;

/**
 *
 * @author mati
 */
public class GestionFicheros {

    public static File raiz;
    public static ArrayList<Tienda> listaTienda = new ArrayList<>();
    public static ArrayList<Factura> listaFacturas = new ArrayList<>();

    public static File getRaiz() {
        return raiz;
    }

    public static void setRaiz(File raiz) {
        GestionFicheros.raiz = raiz;
    }

    public static ArrayList<Tienda> getListaTienda() {
        return listaTienda;
    }

    public static void setListaTienda(ArrayList<Tienda> listaTienda) {
        GestionFicheros.listaTienda = listaTienda;
    }

    public static Factura buscarFactura(String codigo) {
        for (int i = 0; i < listaFacturas.size(); i++) {
            String eh = "" + listaFacturas.get(i).getId();
            if (codigo.trim().equalsIgnoreCase(eh)) {
                return listaFacturas.get(i);
            }
        }
        return null;

    }

    public static void borrarFactura(Factura f) {
        listaFacturas.remove(f);
        File carpetaFacturasCSV = new File("tienda/facturas/CSV/");
        File carpetaFacturasPDF = new File("tienda/facturas/PDF/");
        if (carpetaFacturasCSV.exists() && carpetaFacturasPDF.exists()) {
            File[] ficherosCSV = carpetaFacturasCSV.listFiles();
            for (int i = 0; i < ficherosCSV.length; i++) {
                String nombre = "" + f.getId();
                if (ficherosCSV[i].getName().equalsIgnoreCase(nombre + ".csv")) {
                    ficherosCSV[i].delete();
                }
            }
            File[] ficherosPDF = carpetaFacturasPDF.listFiles();
            for (int i = 0; i < ficherosPDF.length; i++) {
                String nombre = "" + f.getId();
                if (ficherosPDF[i].getName().equalsIgnoreCase(nombre + ".pdf")) {
                    ficherosPDF[i].delete();
                }
                if (ficherosPDF[i].getName().equalsIgnoreCase(nombre + "ConIMG.pdf")) {
                    ficherosPDF[i].delete();
                }
            }
            System.out.println("Eliminado exitosamente");
        }
    }

    public static void generarDocumentoFactura(Factura f) throws FileNotFoundException, DocumentException, IOException {
        Document document = new Document();
        File fact = new File("tienda/facturas/PDF/" + f.getId() + ".pdf");
        if (!fact.exists()) {
            fact.createNewFile();
        }
        PdfWriter.getInstance(document, new FileOutputStream(fact));
        document.open();
        añadirMetadata(document);
        añadirTituloPagina(document, f);
        añadirInfoCliente(document, f);
        añadirInfoFactura(document, f);
        añadirContenido(document, f);
        añadirFooter(document);
        document.close();
        añadirImagen(document, fact, new File("tienda/facturas/PDF/" + f.getId() + "ConIMG.pdf"
        ), new File("src/iconos/logoMATHRedimensionado.png"), new File("direcciones.png"));

    }

    public static void añadirMetadata(Document doc) {
        doc.addTitle(listaTienda.get(0).getNombre());
        doc.addSubject(listaTienda.get(0).getDireccion());
        doc.addKeywords(listaTienda.get(0).getCIF());
        doc.addAuthor(listaTienda.get(0).getTelefono());
        doc.addAuthor(listaTienda.get(0).getWeb());
    }

    public static void añadirTituloPagina(Document document, Factura f)
            throws DocumentException {
        Paragraph preface = new Paragraph();
        // We add one empty line
        añadirLineasVacias(preface, 1);
        // Lets write a big header
        preface.add(new Paragraph(listaTienda.get(0).getNombre()) + " Tienda de compraventa de componentes informaticos y servicios");
        preface.add(new Paragraph(listaTienda.get(0).getDireccion() + " " + listaTienda.get(0).getTelefono() + " "));
        preface.add(new Paragraph("Contamos con " + listaTienda.get(0).getListaClientes().size() + " clientes satisfechos"));
        // Will create: Report generated by: _name, _date
        preface.add(new Paragraph("WEBSITE : " + listaTienda.get(0).getWeb()));
        preface.add(new Paragraph(
                "Factura generada por: " + System.getProperty("user.name") + ", el dia " + new Date()));//$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

        añadirLineasVacias(preface, 1);

        /*preface.add(new Paragraph(
                "This document is a preliminary version and not subject to your license agreement or any other agreement with vogella.com ;-)."));
         */
        document.add(preface);
        //document.newPage();
    }

    public static void añadirInfoCliente(Document document, Factura f) throws DocumentException {
        Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
        Chunk glue = new Chunk(new VerticalPositionMark());
        Paragraph p1 = new Paragraph("", boldFont);
        Paragraph p2 = new Paragraph("");
        Paragraph p3 = new Paragraph("");
        Paragraph p4 = new Paragraph("");
        p1.add(new Chunk(glue));
        p1.add("Informacion sobre el cliente");
        p2.add(new Chunk(glue));
        p2.add(f.getCliente().getDni() + " " + f.getCliente().getNombre());
        p3.add(new Chunk(glue));
        p3.add(f.getCliente().getDireccion() + " " + f.getCliente().getTelefono());
        p4.add(new Chunk(glue));
        p4.add("Esta factura es 1 de las " + f.getCliente().getFacturas().size() + " que tiene el cliente.");
        document.add(p1);
        document.add(p2);
        document.add(p3);
        document.add(p4);
        Paragraph preface = new Paragraph("");
        document.add(preface);
    }

    public static void añadirInfoFactura(Document document, Factura f) throws DocumentException {
        Paragraph preface = new Paragraph();
        añadirLineasVacias(preface, 1);
        document.add(preface);
        PdfPTable table = new PdfPTable(new float[]{30, 55, 30, 30});
        table.setWidthPercentage(100);

        PdfPCell c1 = new PdfPCell(new Phrase("Factura numero"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Fecha realizada"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Num de lineas"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Metodo de pago"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        table.setHeaderRows(1);

        String factnum = "" + f.getId();
        String fecha = "" + f.getFecha();
        String numLinea = "" + f.getListaLineas().size();
        String metodoPago = "" + f.getMp();
        table.addCell(factnum);
        table.addCell(fecha);
        table.addCell(numLinea);
        table.addCell(metodoPago);
        Paragraph p1 = new Paragraph();
        p1.add(table);
        document.add(p1);

    }

    public static void añadirFooter(Document document) throws DocumentException {
        Paragraph preface = new Paragraph();
        añadirLineasVacias(preface, 1);
        document.add(preface);
        Font peque = new Font(Font.FontFamily.TIMES_ROMAN, 6, Font.NORMAL);
        Paragraph p = new Paragraph("Independientemente del derecho de desistimiento descrito anteriormente, la política de devolución de MATH te permite devolver los productos en caso de que no quedes satisfecho con tu compra hasta 30 días desde la fecha de recepción del producto.\n"
                + "Los productos deben ser devueltos en el mismo estado en el que los recibiste. Por lo tanto, los productos nuevos deben ser devueltos nuevos, sin usar y completos. Los productos de segunda mano no deben presentar daños ni signos de uso adicionales.\n"
                + "Las mismas excepciones al derecho de desistimiento se aplican a nuestra política de devoluciones. Los siguientes productos no pueden ser devueltos salvo en caso de productos defectuosos:\n"
                + "Productos que no permitan su devolución debido a razones higiénicas o de protección de la salud si ha sido desprecintado por ti tras su entrega (por ejemplo productos cosméticos), o que estuvieran, tras su entrega, inseparablemente mezclados con otros productos;\n"
                + "Productos que puedan deteriorarse o caducar con rapidez (por ejemplo alimentos o productos perecederos o sometidos a fecha de caducidad);\n"
                + "Grabaciones sonoras o de video precintadas o software sellado si los mismos fueran desprecintados por ti tras su entrega;\n"
                + "Bienes realizados según sus especificaciones o claramente personalizados, incluidos específicamente los productos de MATH Handmade;\n"
                + "Un servicio de MATH si se hubiera prestado y hubieras aceptado su prestación cuando solicitaste el servicio\n"
                + "Contenido digital (incluyendo apps, software digital e-books, MP3, etc.) que no hubiera sido entregado en un soporte material (es decir, no contenidos en soportes como CD o DVD) si hubieras consentido la ejecución en el momento de la entrega y sin que resulte posible su desistimiento desde dicho momento\n"
                + "Prensa diaria, publicaciones periódicas o revistas con la excepción de contratos de suscripción; y;\n"
                + "Bebidas alcohólicas cuyo precio haya sido acordado en el momento en que realizaste el pedido y que no puedan ser entregadas antes de 30 días, y cuyo valor real de dependa de fluctuaciones en el mercado que no podamos controlar.\n"
                + "Nota: si el motivo de la devolución del producto no se debe a que llegó dañado, era defectuoso o era incorrecto, no te reembolsaremos el importe del envoltorio regalo, los gastos de envío ni ningún otro servicio relacionado con tu pedido; únicamente te reembolsaremos el importe del producto. Si utilizas una etiqueta de devolución con franqueo pagado, deduciremos los gastos de envío del importe total del reembolso.\n"
                + "\n"
                + "Esta política de devoluciones no afecta a tus derechos legales de cliente.", peque);

        document.add(p);
    }

    public static void añadirContenido(Document document, Factura f) throws DocumentException {
        Paragraph preface = new Paragraph();
        añadirLineasVacias(preface, 1);
        boolean primeraVez = true;
        //Crear tabla
        for (int i = 0; i < f.getListaLineas().size(); i++) {
            createTable(preface, primeraVez, f, i);
            primeraVez = false;
        }
        añadirLineasVacias(preface, 2);
        document.add(preface);

        Paragraph preface2 = new Paragraph();
        calcularResultadoYPDF(preface2, f);
        document.add(preface2);
    }

    public static void createTable(Paragraph subCatPart, boolean primeraVez, Factura f, int i) throws BadElementException {
        //PdfPTable table = new PdfPTable(3);
        PdfPTable table = new PdfPTable(new float[]{20, 85, 20, 20});
        table.setWidthPercentage(100);
        LineaFactura lf = f.getListaLineas().get(i);
        if (primeraVez == true) {
            PdfPCell c1 = new PdfPCell(new Phrase("Codigo linea"));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("Producto"));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("Cantidad"));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("Coste"));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);
            table.setHeaderRows(1);
        }
        String codLinea = "" + lf.getCodigoLinea();
        String cantidad = "" + lf.getCantidad();
        String coste = "" + lf.getCoste();
        table.addCell(codLinea);
        table.addCell(lf.getProducto().toString());
        table.addCell(cantidad);
        table.addCell(coste);

        subCatPart.add(table);

    }

    public static void añadirLineasVacias(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }

    public static void añadirImagen(Document document, File source, File dest, File img, File qr) {
        try {
            PdfReader reader = new PdfReader(source.getAbsolutePath());
            PdfStamper stamer = new PdfStamper(reader, new FileOutputStream(dest.getAbsolutePath()));
            Image image = Image.getInstance(img.getAbsolutePath());
            Image qrImg = Image.getInstance(qr.getAbsolutePath());

            PdfImage stream = new PdfImage(image, "", null);
            PdfImage stream2 = new PdfImage(qrImg, "", null);
            stream.put(new PdfName("ITXT_SpecialId"), new PdfName("123456789"));
            stream2.put(new PdfName("ITXT_SpecialId"), new PdfName("123456789"));
            PdfIndirectObject ref = stamer.getWriter().addToBody(stream);
            PdfIndirectObject ref2 = stamer.getWriter().addToBody(stream2);
            image.setDirectReference(ref.getIndirectReference());
            qrImg.setDirectReference(ref2.getIndirectReference());
            image.setAbsolutePosition(450, 700);
            qrImg.setAbsolutePosition(26, 590);
            PdfContentByte over = stamer.getOverContent(1);

            over.addImage(image);
            over.addImage(qrImg);
            stamer.close();
            reader.close();
        } catch (IOException ex) {
            Logger.getLogger(Tienda.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(Tienda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void calcularResultadoYPDF(Paragraph subCatPart, Factura f) {
        double totalBruto = 0;
        double totalNeto = 0;
        double IVA = 1.21;
        double dtoVolumen = 0.98;
        double dtoCrypto = 0.90;
        double descuentos;
        double dtoProntoPago = 0.97;
        for (int i = 0; i < f.getListaLineas().size(); i++) {
            totalBruto += f.getListaLineas().get(i).getCoste();
        }
        if (f.getListaLineas().size() > 10) {
            if (f.getMp() == MetodoPago.BITCOIN || f.getMp() == MetodoPago.ETHEREUM || f.getMp() == MetodoPago.LITECOIN || f.getMp() == MetodoPago.IOTA) {
                totalNeto = (totalBruto * dtoProntoPago * dtoVolumen * dtoCrypto) * IVA;
                descuentos = (totalBruto * 0.02) + (totalBruto * 0.03) + (totalBruto * 0.10);
            } else {
                totalNeto = (totalBruto * dtoProntoPago * dtoVolumen) * IVA;
                descuentos = (totalBruto * 0.02) + (totalBruto * 0.03);
            }
        } else {
            if (f.getMp() == MetodoPago.BITCOIN || f.getMp() == MetodoPago.ETHEREUM || f.getMp() == MetodoPago.LITECOIN || f.getMp() == MetodoPago.IOTA) {
                totalNeto = (totalBruto * dtoProntoPago * dtoCrypto) * IVA;
                descuentos = (totalBruto * 0.03) + (totalBruto * 0.10);
            } else {
                totalNeto = (totalBruto * dtoProntoPago) * IVA;
                descuentos = (totalBruto * 0.03);
            }
        }

        PdfPTable table = new PdfPTable(new float[]{20, 20, 20, 20});
        table.setWidthPercentage(100);

        PdfPCell c1 = new PdfPCell(new Phrase("Importe bruto"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Descuentos"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("IVA"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Importe neto"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        table.setHeaderRows(1);

        String importeBruto = "" + totalBruto;
        String descuentoStr = "" + descuentos;
        String IVAstr = "" + (totalBruto * 0.21);
        String importeNeto = "" + totalNeto;
        table.addCell(importeBruto);
        table.addCell(descuentoStr);
        table.addCell(IVAstr);
        table.addCell(importeNeto);
        subCatPart.add(table);
    }

    public static void generacionDeEstructurasBasicas() throws IOException {
        File rutaInicial = new File("tienda");
        if (!rutaInicial.exists()) {
            rutaInicial.mkdir();
        }
        File rutaClientes = new File("tienda/clientes");
        if (!rutaClientes.exists()) {
            rutaClientes.mkdir();
        }
        File rutaEmpleados = new File("tienda/empleados");
        if (!rutaEmpleados.exists()) {
            rutaEmpleados.mkdir();
        }
        File rutaFacturas = new File("tienda/facturas");
        if (!rutaFacturas.exists()) {
            rutaFacturas.mkdir();
        }
        File rutaProductos = new File("tienda/productos");
        if (!rutaProductos.exists()) {
            rutaProductos.mkdir();
        }
        File rutaFacturasCSV = new File("tienda/facturas/CSV");
        if (!rutaFacturasCSV.exists()) {
            rutaFacturasCSV.mkdir();
        }
        File rutaFacturasPDF = new File("tienda/facturas/PDF");
        if (!rutaFacturasPDF.exists()) {
            rutaFacturasPDF.mkdir();
        }

    }

    public static void altaCliente(Cliente c) throws IOException {
        File rutaInicial = new File("tienda/clientes");
        if (rutaInicial.exists()) {
            File ficheroCliente = new File(rutaInicial.getAbsolutePath() + "/" + c.getDni() + ".csv");
            ficheroCliente.createNewFile();
            PrintWriter pw = new PrintWriter(ficheroCliente);
            pw.print(c.formatear());
            pw.close();
        } else {
            System.out.println("No fueron inicializadas las rutas basicas, pruebe otra vez");
            try {
                generacionDeEstructurasBasicas();
            } catch (IOException ex) {
                Logger.getLogger(GestionFicheros.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void bajaCliente(Cliente c) {
        File rutaInicial = new File("tienda/clientes/" + c.getDni() + ".csv");
        if (rutaInicial.exists()) {
            System.out.println("eliminando ficheros...");
            rutaInicial.delete();
        } else {
            System.out.println("No fueron inicializadas las rutas basicas, pruebe otra vez");
            try {
                generacionDeEstructurasBasicas();
            } catch (IOException ex) {
                Logger.getLogger(GestionFicheros.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public static void altaProducto(Producto p) throws IOException {
        File rutaInicial = new File("tienda/productos");
        if (rutaInicial.exists()) {
            File ficheroProducto = new File(rutaInicial.getAbsolutePath() + "/" + p.getCodigo() + ".csv");
            ficheroProducto.createNewFile();
            PrintWriter pw = new PrintWriter(ficheroProducto);
            pw.print(p.formatear());
            pw.close();
        } else {
            System.out.println("No fueron inicializadas las rutas basicas, pruebe otra vez");
            try {
                generacionDeEstructurasBasicas();
            } catch (IOException ex) {
                Logger.getLogger(GestionFicheros.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void altaFactura(Factura f) throws IOException {
        File rutaInicial = new File("tienda/facturas/CSV");
        if (rutaInicial.exists()) {
            File ficheroFactura = new File(rutaInicial.getAbsolutePath() + "/" + f.getId() + ".csv");
            ficheroFactura.createNewFile();
            PrintWriter pw = new PrintWriter(ficheroFactura);
            pw.print(f.formatear());
            pw.close();
        } else {
            System.out.println("No fueron inicializadas las rutas basicas, pruebe otra vez");
            try {
                generacionDeEstructurasBasicas();
            } catch (IOException ex) {
                Logger.getLogger(GestionFicheros.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void cargarFacturas() throws FileNotFoundException, ParseException, lineaFacturaExistente {
        File rutaInicial = new File("tienda/facturas/CSV");
        File[] facturas = rutaInicial.listFiles();
        System.out.println("Hay " + facturas.length + " facturas");
        for (int i = 0; i < facturas.length; i++) {
            Scanner sc = new Scanner(facturas[i]);
            Factura nuevaFactura = null;
            while (sc.hasNext()) {
                String linea = sc.nextLine();
                String[] datos = linea.split(";");
                String lineaFactura = "";
                Cliente c = controlador.GestionFicheros.listaTienda.get(0).buscarCliente(datos[1]);//De esta forma tenemos el cliente
                if (datos[4].equalsIgnoreCase("efectivo")) {
                    nuevaFactura = new Factura(Integer.parseInt(datos[0]), c, datos[2], Double.parseDouble(datos[3]), MetodoPago.EFECTIVO);
                }
                if (datos[4].equalsIgnoreCase("TARJETA_BANCARIA")) {
                    nuevaFactura = new Factura(Integer.parseInt(datos[0]), c, datos[2], Double.parseDouble(datos[3]), MetodoPago.TARJETA_BANCARIA);
                }
                if (datos[4].equalsIgnoreCase("BITCOIN")) {
                    nuevaFactura = new Factura(Integer.parseInt(datos[0]), c, datos[2], Double.parseDouble(datos[3]), MetodoPago.BITCOIN);
                }
                if (datos[4].equalsIgnoreCase("ETHEREUM")) {
                    nuevaFactura = new Factura(Integer.parseInt(datos[0]), c, datos[2], Double.parseDouble(datos[3]), MetodoPago.ETHEREUM);
                }
                if (datos[4].equalsIgnoreCase("LITECOIN")) {
                    nuevaFactura = new Factura(Integer.parseInt(datos[0]), c, datos[2], Double.parseDouble(datos[3]), MetodoPago.LITECOIN);
                }
                if (datos[4].equalsIgnoreCase("IOTA")) {
                    nuevaFactura = new Factura(Integer.parseInt(datos[0]), c, datos[2], Double.parseDouble(datos[3]), MetodoPago.IOTA);
                }
                int k = 0;
                for (int j = 6; j < datos.length; j++) {
                    lineaFactura += datos[j] + ";";
                    if (k == 4) {
                        k = 0;
                        //System.out.println(lineaFactura);
                        String[] lfarray = lineaFactura.split(";");
                        //System.out.println("busqueda de producto por " + lfarray[1]);
                        Producto p = controlador.GestionFicheros.listaTienda.get(0).buscarProducto(lfarray[1].trim());
                        LineaFactura lf = new LineaFactura(Integer.parseInt(lfarray[0]), p, Integer.parseInt(lfarray[2]), Double.parseDouble(lfarray[3]));
                        nuevaFactura.añadirLineaAFacturaExpress(lf);
                    }
                    k++;
                }

            }
            controlador.GestionFicheros.listaFacturas.add(nuevaFactura);
            sc.close();
        }
    }

    public static void redistribuirFacturas() {
        ArrayList<Cliente> listaClientes = controlador.GestionFicheros.listaTienda.get(0).getListaClientes();
        for (int i = 0; i < listaClientes.size(); i++) {
            for (int j = 0; j < listaFacturas.size(); j++) {
                if (listaClientes.get(i).getDni().equalsIgnoreCase(listaFacturas.get(j).getCliente().getDni())) {
                    listaClientes.get(i).getFacturas().add(listaFacturas.get(j));
                    System.out.println("Añadida factura a " + listaClientes.get(i).getNombre());
                }
            }
        }

    }

    public static void cargarProductos() throws FileNotFoundException, productoExistente {
        File rutaInicial = new File("tienda/productos/");
        File[] productos = rutaInicial.listFiles();
        System.out.println("Hay " + productos.length + " productos");
        for (int i = 0; i < productos.length; i++) {
            Scanner sc = new Scanner(productos[i]);
            while (sc.hasNext()) {
                String linea = sc.nextLine();
                String[] contenido = linea.split(";");
                if (contenido[0].equalsIgnoreCase("Pieza")) {
                    Pieza p = new Pieza(Integer.parseInt(contenido[4]), contenido[2], contenido[1], Double.parseDouble(contenido[3]));
                    controlador.GestionFicheros.listaTienda.get(0).añadirProducto(p);
                }
                if (contenido[0].equalsIgnoreCase("Ordenador")) {
                    Ordenador o = new Ordenador(Integer.parseInt(contenido[4]), contenido[2], contenido[1], Double.parseDouble(contenido[3]));
                    controlador.GestionFicheros.listaTienda.get(0).añadirProducto(o);
                }
                if (contenido[0].equalsIgnoreCase("Servicio")) {
                    Servicio s = new Servicio(Double.parseDouble(contenido[4]), contenido[2], contenido[1], Double.parseDouble(contenido[3]));
                    controlador.GestionFicheros.listaTienda.get(0).añadirProducto(s);
                }
            }
            sc.close();
        }

    }

    public static void cargarCliente() throws FileNotFoundException, IOException, clienteExistente {
        File rutaInicial = new File("tienda/clientes/");
        File[] clientes = rutaInicial.listFiles();
        System.out.println("Hay " + clientes.length + " clientes");
        for (int i = 0; i < clientes.length; i++) {
            Scanner sc = new Scanner(clientes[i]);
            String[] datos;
            Cliente c;
            while (sc.hasNext()) {
                String linea = sc.nextLine();
                datos = linea.split(";");
                c = new Cliente(datos[1], datos[2], datos[0], datos[3]);
                controlador.GestionFicheros.listaTienda.get(0).añadirCliente(c);
            }
            sc.close();
        }
    }

    public static void altaEmpleado(Empleado f) throws IOException {
        File rutaInicial = new File("tienda/empleados");
        if (rutaInicial.exists()) {
            File destino = new File(rutaInicial.getAbsolutePath() + "/" + f.getDni() + ".csv");
            destino.createNewFile();
            PrintWriter pw = new PrintWriter(destino);
            pw.print(f.formatear());
            pw.close();
        } else {
            System.out.println("No fueron inicializadas las rutas basicas, pruebe otra vez");
            try {
                generacionDeEstructurasBasicas();
            } catch (IOException ex) {
                Logger.getLogger(GestionFicheros.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public static void cargarEmpleados() throws FileNotFoundException, empleadoExistente, IOException {
        File rutaInicial = new File("tienda/empleados/");
        File[] fichEmpleados = rutaInicial.listFiles();
        for (int i = 0; i < fichEmpleados.length; i++) {
            Scanner sc = new Scanner(fichEmpleados[i]);
            while (sc.hasNext()) {
                String linea = sc.nextLine();
                String[] datos = linea.split(";");
                String tipoEmpleado = datos[0].trim();
                int codEmple = Integer.parseInt(datos[1].trim());
                String nombre = datos[2].trim();
                String dni = datos[3].trim();
                double sueldo = Double.parseDouble(datos[4].trim());
                String cuenta = datos[5].trim();
                String contra = datos[6].trim();
                if (tipoEmpleado.equalsIgnoreCase("Administrador")) {
                    int antiguedad = Integer.parseInt(datos[7].trim());
                    EmpleadoAdmin ea = new EmpleadoAdmin(codEmple, antiguedad, dni, nombre, sueldo, cuenta, contra);
                    System.out.println("Añadido empleado num " + ea.getNumEmpleado() + " con nombre " + ea.getNombre());
                    controlador.GestionFicheros.listaTienda.get(0).añadirEmpleado(ea);
                } else if (tipoEmpleado.equalsIgnoreCase("Normal")) {
                    EmpleadoNormal en = new EmpleadoNormal(codEmple, dni, nombre, sueldo, cuenta, contra);
                    System.out.println("Añadido empleado num " + en.getNumEmpleado() + " con nombre " + en.getNombre());
                    controlador.GestionFicheros.listaTienda.get(0).añadirEmpleado(en);
                }

            }
            sc.close();
        }
        generarUsuariosVerdaderos();

    }

    public static void generarUsuariosVerdaderos() throws IOException {
        File empleadoscsv = new File("empleados.csv");
        if (!empleadoscsv.exists()) {
            empleadoscsv.createNewFile();
        }
        ArrayList<Empleado> listaEmpleados = controlador.GestionFicheros.listaTienda.get(0).getListaEmpleados();
        PrintWriter pw = new PrintWriter(empleadoscsv);
        for (int i = 0; i < listaEmpleados.size(); i++) {
            pw.print(listaEmpleados.get(i).formatoUsuario()+"\n");
        }
        pw.close();
    }

}
