import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Teszter {

	public static void main(String[] args) {

	}

	public void Compare(String sampletest, String outputtest) throws IOException {

		Path sample = Paths.get(sampletest);
		Path output = Paths.get(outputtest);
		byte[] sample_array = Files.readAllBytes(sample); // A tesztesethez
															// tartoz�
															// mintakimenet
															// bin�ris�t
															// bet�ltj�k
		byte[] output_array = Files.readAllBytes(output); // A teszteset
															// kimenet�nek
															// bin�ris�t
															// bet�ltj�k

		boolean egyezik = true;
		for (int i = 0; i < sample_array.length && i < output_array.length; i += 1) {
			if (sample_array[i] != output_array[i]) {
				System.out.println("Elt�r�s az " + i + " poz�tci�ban.");
				egyezik = false;
			}
		}

		if (egyezik) // Arrays.equals(sample_array,output_array))
		{ // A k�t f�jl bin�ris tartalm�t ellen�rizz�k, ha ezek egyeznek, akkor
			// a k�t f�jl tartalma is.

			System.out.println("A kiement megegyezik az elvartakkal!");
		} else {
			System.out.println("A kimenet elter az elvartaktol");
		}
	}
}
