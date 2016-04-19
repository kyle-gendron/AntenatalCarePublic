package edu.usm.cos420.health.consultingregister.service;

import javax.swing.text.DocumentFilter;
import javax.swing.text.Document;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;

/** 
 * Validate text fields for floating point numbers.
 *
 * Filter the input going into the text fields which should be floating point
 * numbers.
 *
 * @author Samuel Barton
 */
public class FloatingPointFieldValidator extends DocumentFilter
{
    private static FloatingPointFieldValidator validator;

    protected FloatingPointFieldValidator()
    {
        super();
    }

    public static FloatingPointFieldValidator getInstance()
    {
        if (validator == null)
            validator = new FloatingPointFieldValidator();

        return validator;
    }

    /** 
     * Filter out non-digits.
     *
     * This method makes it so only floating point numbers can be entered.
     * 
     * Only a digit or a '.' can be entered, and a '.' can only be entered if at
     * least one digit has been entered already.
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
            else if (string.equals("."))
            {
                Document doc = fb.getDocument();
                String text = doc.getText(0, doc.getLength());
                if (text.isEmpty() || text.contains("."))
                    string = "";
            }
            else
                string = "";
        }
        super.replace(fb, offset, length, string, attr);
    }
}
