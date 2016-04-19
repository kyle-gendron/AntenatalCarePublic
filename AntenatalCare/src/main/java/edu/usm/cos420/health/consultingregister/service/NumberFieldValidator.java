package edu.usm.cos420.health.consultingregister.service;

import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.text.DocumentFilter;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;

/** 
 * Validate text fields for numbers.
 *
 * Filter the input going into the number
 *
 * @author Samuel Barton
 */
public class NumberFieldValidator extends DocumentFilter
{
    private static NumberFieldValidator validator;

    protected NumberFieldValidator()
    {
        super();
    }

    public static NumberFieldValidator getInstance()
    {
        if (validator == null)
            validator = new NumberFieldValidator();

        return validator;
    }

    /** 
     * Filter out non-digits.
     *
     * This method makes it so only digits can be entered.
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
            if (!Character.isDigit(string.codePointAt(0)))
                string = "";
        }
        super.replace(fb, offset, length, string, attr);
    }
}
