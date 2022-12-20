/*
 * Problem number: ${NAME}
 * Created date: ${DATE} ${TIME}
 * Created with: ${PRODUCT_NAME}
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ${NAME} {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input/${NAME}.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> input = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) input.add(line);
        br.close();
    }
}