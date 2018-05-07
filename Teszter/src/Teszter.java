import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Teszter {

	public static void main(String[] args) {
		System.out.println("A kiement megegyezik az elvartakkal!");

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

		if (Arrays.equals(sample_array, output_array)) { // A két fájl bináris
															// tartalmát
															// ellenõrizzük, ha
															// ezek egyeznek,
															// akkor a két fájl
															// tartalma is.
			System.out.println("A kiement megegyezik az elvartakkal!");
		} else {
			System.out.println("A kimenet elter az elvartaktol");
		}
	}
}
