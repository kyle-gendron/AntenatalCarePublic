package edu.usm.cos420.health.consultingregister.service;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Color;

/** 
 * Validate text fields for dates.
 *
 * This ensures that if a date textfield is empty, then it's associated value
 * is set to null. Also, it does not allow dates to be in the future. This is
 * important for the date-of-birth field.
 *
 * @author Samuel Barton
 */
public class DateFieldValidator extends InputVerifier
{
    private static DateFieldValidator validator;
    private static SimpleDateFormat format;

    static
    {
        format = new SimpleDateFormat("MM/dd/yyyy");
    }

    protected DateFieldValidator()
    {
        super();
    }

    /** 
     * Gives out a reference to the validator.
     * 
     * This maintains the singleton patern by creating a new instance of the
     * validator if one does not exist, but not creating additional ones to
     * pass out after one has been created.
     *
     * @return a reference to the date validator
     */
    public static DateFieldValidator getInstance()
    {
        if (validator == null)
            validator = new DateFieldValidator();

        return validator;
    }

    /** 
     * Verify the input.
     *
     * This method determins whether or not the text entered is valid. It does
     * not handle date parsing, as that is done by the 
     *
     * @param input the JComponent where the input was made.
     * @return whether or not the input is valid.
     *
     */
    public boolean verify(JComponent input)
    {
        if (input instanceof JFormattedTextField)
        {
            JFormattedTextField ftf = (JFormattedTextField)input;
            String text = ftf.getText();

            Date input_date = null;

            try
            {
                    input_date = format.parse(text);
            }
            catch (Exception e)
            {
                ftf.setText("");
            }

            Date current_time = new Date();
            if (input_date != null && current_time.before(input_date))
                ftf.setText("");;

            return true;
        }
        return false;
    }

    /** 
     * Determine if the component should give up the focus.
     *
     * This method determines if the JComponent it is passed should give up its
     * focus. It does so by verifying that the input is valid.
     *
     * @param input the JCompnent with the focus
     * @return whether or not it should lose the focus
     */
    public boolean shouldFieldFocus(JComponent input)
    {
        return verify(input);
    }
}
