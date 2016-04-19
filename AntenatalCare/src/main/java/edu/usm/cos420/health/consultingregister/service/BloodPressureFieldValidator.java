package edu.usm.cos420.health.consultingregister.service;

import javax.swing.text.DocumentFilter;
import javax.swing.text.Document;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;

/** 
 * Validate text fields for floating point numbers.
 *
 * Filter the input going into the text field for blood pressure.
 *
 * @author Samuel Barton
 */
public class BloodPressureFieldValidator extends DocumentFilter
{
    private static BloodPressureFieldValidator validator;

    protected BloodPressureFieldValidator()
    {
        super();
    }

    public static BloodPressureFieldValidator getInstance()
    {
        if (validator == null)
            validator = new BloodPressureFieldValidator();

        return validator;
    }

    /** 
     * Only allow strings of the form W/W where W is a list of non-negative
     * integers.
     *
     * As of now it is such that you can only enter values which meet the 
     * String requirements. In time it may also be that the first number must
     * be greater than the second.
     *
     * @param fb the filter bypass
     * @param offset the offset from the beginning of the document
     * @param length the length of hte input string
     * @param string the input string
     * @param attr the set of attributes for this document
     * @throws BadLocationException the location given is outside of the document
     */
    public void replace(FilterBypass fb, 
                        int offset, 
                        int length, 
                        String string, 
                        AttributeSet attr) throws BadLocationException 
    {
        if (string != null)
        {
            if (Character.isDigit(string.codePointAt(0)))
            {} // do nothing
            else if (string.equals("/"))
            {
                Document doc = fb.getDocument();
                String text = doc.getText(0, doc.getLength());
                if (text.isEmpty() || text.contains("/"))
                    string = "";
            }
            else
                string = "";
        }
        super.replace(fb, offset, length, string, attr);
    }
}
