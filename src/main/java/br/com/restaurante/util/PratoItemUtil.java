package br.com.restaurante.util;

import br.com.restaurante.model.ItemDeCompra;
import br.com.restaurante.model.Prato;

public class PratoItemUtil {
	public static ItemDeCompra transformaPratoEmItem(Prato prato) {
		ItemDeCompra item = new ItemDeCompra(prato);
		return item;
	}
}
