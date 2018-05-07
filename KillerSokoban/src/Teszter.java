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
															// tartozó
															// mintakimenet
															// binárisát
															// betöltjük
		byte[] output_array = Files.readAllBytes(output); // A teszteset
															// kimenetének
															// binárisát
															// betöltjük

		boolean egyezik = true;
		for (int i = 0; i < sample_array.length && i < output_array.length; i += 1) {
			if (sample_array[i] != output_array[i]) {
				System.out.println("Eltérés az " + i + " pozítcióban.");
				egyezik = false;
			}
		}

		if (egyezik) // Arrays.equals(sample_array,output_array))
		{ // A két fájl bináris tartalmát ellenõrizzük, ha ezek egyeznek, akkor
			// a két fájl tartalma is.

			System.out.println("A kiement megegyezik az elvartakkal!");
		} else {
			System.out.println("A kimenet elter az elvartaktol");
		}
	}
}
