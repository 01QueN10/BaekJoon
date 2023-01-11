/*
 * Problem number: p10478.txt
 * Created date: 2022-12-20 오후 4:37
 * Created with: IntelliJ IDEA
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class p10478 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/p10478.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<String> input = new ArrayList<>();
		String l;
		while ((l = br.readLine()) != null) input.add(l);
		br.close();

		int n = 0;
		int remain = 0;
		Node firstNode = null;
		Map<String, Node> nodes = new HashMap<>();
		for (String line : input) {
			if (remain == 0) { // init
                if (n != 0) {
                    while (firstNode.previous != null) firstNode = firstNode.previous;

                    int size = 1;
                    while (firstNode.next != null) {
                        System.out.print(size);
                        System.out.print(firstNode.name);
                        System.out.print(" = ");
                        firstNode = firstNode.next;
                        size *= firstNode.multiplier;
                    }
                    System.out.print(size);
                    System.out.println(firstNode.name);
                }
                nodes = new HashMap<>();
                remain = Integer.parseInt(line);
				n = remain;
				continue;
			}

			if (remain == n) {
				String[] measures = line.split(" ");
				for (String measure : measures) {
					nodes.put(measure, new Node(measure));
				}
				firstNode = nodes.get(measures[0]);

				remain--;
				continue;
			}

			String[] words = line.split(" ");
			Node prev = nodes.get(words[0]);
			Node next = nodes.get(words[3]);
			prev.next = next;
			next.previous = prev;
			next.multiplier = Integer.parseInt(words[2]);

			remain--;
		}
	}

	private static class Node {
		public Node(String name) {
			this.name = name;
		}

		public String name;
		public int multiplier = 1;
		public Node next;
		public Node previous;
	}
}