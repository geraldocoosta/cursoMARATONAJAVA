package com.ultcode.padroesdeprojetostrategy.classes;

import com.ultcode.padroesdeprojetostrategy.interfaces.Comissao;

public enum Cargo implements Comissao {
	ATENDENTE {
		@Override
		public double calculaComissao(double valor) {
			return valor * 0.1;
		}
	},
	VENDEDOR {
		@Override
		public double calculaComissao(double valor) {
			return valor * 0.15 + 5;
		}
	},
	GERENTE {
		@Override
		public double calculaComissao(double valor) {
			return valor * 0.20 + 10;
		}
	};

	@Override
	public double calculaComissao(double valor) {
		return 0;
	}
}
