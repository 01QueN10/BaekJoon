/*
 * Problem number: p10478b
 * Created date: 2023-01-11 오후 4:56
 * Created with: IntelliJ IDEA
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class p10478b {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/p10478b.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<String> input = new ArrayList<>();
		String line;
		while ((line = br.readLine()) != null) input.add(line);
		br.close();
	}
}