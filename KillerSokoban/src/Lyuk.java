
//Lyuk osztaly
public class Lyuk extends Mezo {
 private boolean Nyitott = false;
 
 public Lyuk(){
	 System.out.println("Lyuk konstruktor");
 }
 
 /*Megkerdezik hogy mozoghatnak e ra ennek megfeleloen vaaszol
  * ha van rajta valami akkor annak is meghivja a mozog fuggvenyet
  * @see Mezo#Mozog(Irany)
  */
 public Kimenetel Mozog(Irany i){
		Kimenetel a = null;
		return a;
 }
 //Hozza ad egy munkast
 public void Add(Munkas m){
	 System.out.println("Add (munkas)");
 }
 //Hozza ad egy ladat
 public void Add(Lada l){
	 System.out.println("Add (lada)");
 }
 //Kitorli a rajta levo elemet
 public void Torol(){
	 System.out.println("Torol");
 }
 
}

