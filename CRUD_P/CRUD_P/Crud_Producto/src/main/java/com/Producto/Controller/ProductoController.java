package com.Producto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Producto.Entity.Categoria;
import com.Producto.Entity.Estado;
import com.Producto.Entity.Producto;
import com.Producto.Entity.Proveedor;
import com.Producto.Services.CategoriaServices;
import com.Producto.Services.EstadoServices;
import com.Producto.Services.ProductoServices;
import com.Producto.Services.ProveedorServices;

@Controller
@RequestMapping("/Productos")
public class ProductoController {
	@Autowired
	private CategoriaServices serCate;
	@Autowired
	private EstadoServices serEstado;
	@Autowired
	private ProductoServices serPro;
	@Autowired
	private ProveedorServices serProvee;
	
	@RequestMapping("/lista")
	public String index(Model model) {
		model.addAttribute("listaProductos",serPro.listarProducto());
		model.addAttribute("listaCategoria",serCate.listaTodo());
		model.addAttribute("listaEstado", serEstado.listaTodo());
		model.addAttribute("listaProveedor", serProvee.listaTodo());
		return "producto";
	}
	@RequestMapping("/buscar")
	@ResponseBody//--- para convertir en JSON el objeto retornado 
	public Producto buscarPorID(@RequestParam("codigo") Integer cod) {
		return serPro.buscarPorID(cod);
	}
	
	@RequestMapping("/eliminar")
	public String eliminarPorID(@RequestParam("codigo") Integer cod,
								RedirectAttributes redirect) {
		serPro.eliminarPorID(cod);
		redirect.addFlashAttribute("MENSAJE","Producto eliminado");
		
		return "redirect:/Productos/lista";
	}
	
	@RequestMapping("/grabar")	
	public String grabar(@RequestParam("codigo") Integer cod,
							@RequestParam("nombre") String nom,
							@RequestParam("descripcion") String des,
							@RequestParam("imagen")String img,
							@RequestParam("precio") double pre,
							@RequestParam("stock")int stk,
							@RequestParam("categoria")int cate,
							@RequestParam("proveedor")int provee,
							@RequestParam("estado")int esta,
							
							
							RedirectAttributes redirect) {
		try {
			//crear objeto de la entidad Medicamento
			Producto pro=new Producto();
			//setear
			pro.setNombre(nom);
			pro.setDescripcion(des);
			pro.setImagen(img);
			pro.setPrecio(pre);
			pro.setStock(stk);
			
			
			//crear objeto de la entidad TipoMedicamento 
			Categoria c=new Categoria();
			Estado e = new Estado();
			Proveedor p=new Proveedor();
			//setear codigo
			c.setCodigo(cate);
			e.setCodigo(esta);
			p.setCodigo(provee);
			//enviar objeto "tm" al objeto "med"
			pro.setCategoria(c);
			pro.setEstado(e);
			pro.setProveedor(p);
			//valida cod
			if(cod==0) {
				//invocar al método registrarr
				serPro.registrar(pro);
				//crear un atributo
				redirect.addFlashAttribute("MENSAJE","Producto registrado");
			}
			else {
				//setear el código del objeto pro
				pro.setCodigo(cod);
				//invocar al método actualizar
				serPro.actualizar(pro);
				//crear un atributo
				redirect.addFlashAttribute("MENSAJE","Producto actualizado");					
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/Productos/lista";
	}
	
}
