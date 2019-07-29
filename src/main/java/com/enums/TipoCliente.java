package com.enums;

public enum TipoCliente {

		PESSOAFISICA(1, "Pessoa Fisica"), 
		PESSOAJURIDICA(2, "Pessoa Juridica");
	
		private int cod;
		private String descricao;
		
		private TipoCliente (int cod, String descricao) {
			this.cod = cod;
			this.descricao = descricao;
		}
		
		public int getCod() {
		return cod;
		}
		
		public String getDescricao () {
			
			return descricao;
		}
		
		// converter o tipo para cod para verificar qual codigo corresponde a qual tipo de cliente.
		
		public static TipoCliente toEnum(Integer cod) {
			if (cod == null)
			return null;
			
			for (TipoCliente x: TipoCliente.values()) {
				return x;
			}
			
			throw new IllegalArgumentException("Id invalido: " + cod);
		}
}
