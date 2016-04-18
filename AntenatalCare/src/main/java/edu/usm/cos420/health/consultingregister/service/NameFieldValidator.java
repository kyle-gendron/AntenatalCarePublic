package edu.usm.cos420.health.consultingregister.service;

import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.text.DocumentFilter;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;

/** 
 * Validate text fields for names.
 *
 * The text field for first name, last name, town, villiage, tribe, and other
 * names need validation just like the others. Each name needs to be an
 * alphabetic string. We don't allow numbers or symbols in names. 
 *
 * @author Samuel Barton
 */
public class NameFieldValidator extends DocumentFilter
{
    private static NameFieldValidator validator;

    /** 
     * Default constructor, only visible to subclasses.
     */
    protected NameFieldValidator()
    {
        super();
    }

    /** 
     * Get a reference to the validator.
     *
     * This method enables the Singleton pattern by creating a new instance of
     * the validator only when one does not already exist.
     * @return a reference to the validator
     */
    public static NameFieldValidator getInstance()
    {
        if (validator == null)
            validator = new NameFieldValidator();

        return validator;
    }

    /** 
     * Filter the input to the text field.
     *
     * This method filters the input text dropping all non-alphabetic 
     * characters.
     *
     * @param fb the filter bypass
     * @param offset the offset from the beginning of the document
     * @param length the length of the string
     * @param string the string entered
     * @param attr the set of attributes associated with the Document
     * @throws BadLocationException the location is outside the bounds of the Document.
     */
    public void replace(FilterBypass fb, 
                        int offset, 
                        int length, 
                        String string, 
                        AttributeSet attr) throws BadLocationException 
    {
        if (string != null)
        {
            if (!Character.isAlphabetic(string.codePointAt(0)))
                string = "";
        }
        super.replace(fb, offset, length, string, attr);
    }
}
