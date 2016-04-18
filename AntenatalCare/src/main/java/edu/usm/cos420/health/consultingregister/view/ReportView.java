package edu.usm.cos420.health.consultingregister.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;


import edu.usm.cos420.health.consultingregister.data.RegisterDao;

public class ReportView extends JFrame
{
   private JTable table;
   private JFrame frame;
   private JScrollPane scrollPane;
   private JTableHeader header;
   
   public ReportView()
   {
	   initTable();
   }

   private void initTable() 
   {
	    final int WINDOW_WIDTH;
	    final int WINDOW_HEIGHT;
	    
	        Rectangle screen_size = GraphicsEnvironment.
	                                getLocalGraphicsEnvironment().
	                                getMaximumWindowBounds();

	        WINDOW_WIDTH = screen_size.width;
	        WINDOW_HEIGHT = screen_size.height;

	 this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	 scrollPane = new JScrollPane();
	 table = new JTable() {
     /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	@Override
     public boolean isCellEditable(int row, int column) {                
         return false;  }
     
     public Component prepareRenderer(
         TableCellRenderer renderer, int row, int col) {
         if (col == 0) {
             return this.getTableHeader().getDefaultRenderer()
                 .getTableCellRendererComponent(this, this.getValueAt(
                     row, col), false, false, row, col);
         } else {
             return super.prepareRenderer(renderer, row, col);
         }
     }
 };
     table.setAutoCreateRowSorter(false);
     this.setTitle("Outpatient Morbidity Report");
     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 RegisterDao temp = new RegisterDao();
	 header = table.getTableHeader();
	 //header.setDefaultRenderer(new HeaderRenderer(table));
	 
	 int[][] date = temp.generateReport("3/15/2016", "3/30/2016");
	 
	 Object[][] tableData = new Object[77][26];
	 for(int i = 0; i<76; i++)
	 {
		 tableData[i][0] = temp.diseaseArray[i];
		 for(int a = 1; a<26; a++)
		 {
		   //tableData[i][a+1] = date[i][a];
		   tableData[i][a] = date[i][a-1];
		 }
	 }
	 //Last line with grand totals
	 for(int i = 1; i<26; i++)
	 {
		tableData[76][i] = date[76][i-1];
	 }
	 tableData[76][0] = "TOTAL";
	 
	 table.setModel(new DefaultTableModel(tableData
			 							  //new Object [][] {
        //{temp.diseaseArray[0], date[0][1], date[0][2], date[0][3], date[0][4],date[0][5],date[0][6],date[0][7],date[0][8],date[0][9]},
        //{temp.diseaseArray[1], "Data 6", "Data 7", "Data 8", "Data 9"},
        //{temp.diseaseArray[2], "Data 10", "Data 11", "Data 12", "Data 13"}
    //},
    ,
    new String [] {
        "", "<1", "1-4", "5-9", "10-14","15-17","18-19","20-34","35-49","50-59","60-69","70+","TOTAL","<1","1-4"
        , "5-9", "10-14","15-17","18-19","20-34","35-49","50-59","60-69","70+","TOTAL","GR. TOTAL"
        //temp.diseaseArray
    }
			));
	scrollPane.setViewportView(table);
	this.add(scrollPane);
	table.getTableHeader().setReorderingAllowed(false);
	//table.isCellEditable(row, column);
	//this.add(table);
	this.setVisible(true);
   }
   
   public static void main(String[] args)
   {
	   ReportView temp = new ReportView();
   }
}
