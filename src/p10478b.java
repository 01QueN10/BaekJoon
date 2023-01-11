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
import java.util.Arrays;
import java.util.List;

public class p10478b {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/p10478b.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<String> input = new ArrayList<>();
		String line;
		while ((line = br.readLine()) != null) input.add(line);
		br.close();

		int cursor = 0;
		while (cursor <= input.size()) {
			int size = Integer.parseInt(input.get(cursor));
			List<String> sublist = input.subList(cursor + 1, cursor + 1 + size);
			System.out.println(Parser.parseChunk(sublist));
			cursor += 1 + size;
		}
	}

	static class Parser {
		public static String parseChunk(List<String> strings) {
			String base = findBiggest(strings.subList(1, strings.size()));
			List<Node> nodes = new ArrayList<>();

			for (String measure : strings.get(0).split(" ")) nodes.add(new Node(measure));
			for (String line : strings.subList(1, strings.size())) parseRelationship(line, nodes);
		}

		public static void parseRelationship(String line, List<Node> nodes) {
		}

		public static String findBiggest(List<String> strings) {
			List<String> subtractor = new ArrayList<>();
			for (String line : strings) subtractor.add(line.split(" ")[3]);
			List<String> target = Arrays.asList(strings.get(0).split(" "));
			target.removeAll(subtractor);
			return target.get(0);
		}
	}

	static class Node {

		String name;
		int multiplier = 1;

		public Node(String name) {
			this.name = name;
		}
	}
}