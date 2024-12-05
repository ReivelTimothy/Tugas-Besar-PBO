package view;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import javax.swing.JFormattedTextField.AbstractFormatter;
import java.util.Date;

public class DateLabelFormatter extends AbstractFormatter {
    private final SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");

    @Override
    public Object stringToValue(String text) throws ParseException {
        if (text == null || text.trim().isEmpty()) {
            return null; // Handle empty string input gracefully
        }
        return dateFormatter.parse(text); // Attempt to parse the date
    }

    @Override
    public String valueToString(Object value) {
        if (value instanceof Date) {
            return dateFormatter.format((Date) value); // Only format if value is a Date
        }
        return ""; // Return empty string if the value is not a Date object
    }
}
