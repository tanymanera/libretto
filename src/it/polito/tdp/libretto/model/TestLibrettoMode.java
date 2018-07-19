package it.polito.tdp.libretto.model;

public class TestLibrettoMode {

	public static void main(String[] args) {
		ModelLibretto lib = new ModelLibretto();
		
		lib.addEsame(new Esame("03FYZ", "Tecniche di Programmazione", "Fulvio Corno"));
		lib.addEsame(new Esame("01QZP", "Ambient Intelligence", "Fulvio Corno"));
		
		System.out.println(lib.findEsame("03FYZ"));
		System.out.println(lib.findEsame("01QZP"));
		System.out.println(lib.findEsame("99QQQ"));
		
		try {
			lib.addEsame(new Esame("01QZP", "Ambient Intelligence", "Fulvio Corno"));
		}catch(IllegalStateException e) {
			System.out.println(e.getMessage());
		}
	}

}
