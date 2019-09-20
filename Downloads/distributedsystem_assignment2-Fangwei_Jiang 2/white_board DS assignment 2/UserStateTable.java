/* ************************************************************************************
 * Group Name: Friday615
 * Group Members: Chih-chi Chou, Fangwei Jiang, Pei-chun kao, Yixuan Tang, Ruiyan Wang
 * Description: This program is designed to create a dynamic user activity table 
 *				for manager's convenience.
 ************************************************************************************ */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

public class UserStateTable extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JTable jg_table;
	private JScrollPane jsp;
	private Vector<List<String>> vect = new Vector<List<String>>();
	private Vector<String> list = new Vector<String>();
	private final String[] columnNames = { "Identification", "UserName", "Online?", "Time"};
	
	public static void main(String[] args) 
	{
		try 
		{
			UserStateTable frame = new UserStateTable();
			frame.setTitle("Dynamic user state table");
			frame.setDefaultCloseOperation(0);
			frame.setVisible(true);
			frame.addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent e) 
				{
					int n = JOptionPane.showConfirmDialog(null, 
						"Do you really want to close the User Activity Table?", "Confirm", 1);
					if (n == 0) 
					{
						System.exit(0);
					}
				}
			});
			while (true) 
			{
				Vector<String> list = new Vector<String>();
				list.add("Client");
				list.add("fangweij");
				list.add("Yes");
				String c = Calendar.getInstance().getTime().toString();
				list.add(c);
				
				Thread.sleep(1000);
				frame.getVect().add(list);
				((AbstractTableModel)frame.getJg_table().getModel()).fireTableDataChanged();
				//frame.getJg_table().updateUI();
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public UserStateTable() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1500, 1000, 800, 500);
		getContentPane().setLayout(new BorderLayout(0, 0));
		AbstractTableModel tm = new AbstractTableModel() 
		{
			private static final long serialVersionUID = 1L;
			@Override
			public int getColumnCount() 
			{
				return columnNames.length;
			}
			
			@Override
			public int getRowCount()
			{
				return vect.size();
			}
			
			@Override
			public Object getValueAt(int row, int column) 
			{
				if (!vect.isEmpty())
				{
					return ((Vector<String>) vect.elementAt(row)).elementAt(column);
				}
				else
				{
					return null;
				}
			}

			@Override
			public String getColumnName(int column)//set the column names
			{
				return columnNames[column];
			}	
		};

		vect.removeAllElements();
		tm.fireTableStructureChanged();
		
		list.add("Manager");
		list.add("Fangwei Jiang");
		list.add("Yes");
		list.add(Calendar.getInstance().getTime().toString());
		
		vect.addElement(list);
		
		tm.fireTableStructureChanged();
		jg_table = new JTable(tm);
		jg_table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jg_table.setCellSelectionEnabled(false);
		jg_table.setShowVerticalLines(true);
		jg_table.setShowHorizontalLines(true);
		setTableStyle(jg_table);
		
		jsp = new JScrollPane(jg_table);
		
		jsp.addComponentListener(new ComponentAdapter() 
		{
			@Override
			public void componentResized(ComponentEvent e) 
			{
				resizeTable(true);
			}
		});
		getContentPane().add(jsp, BorderLayout.CENTER);
	}
	public void resizeTable(boolean bool) 
	{
		Dimension containerwidth = null;
		if (!bool) 
		{
			containerwidth = jsp.getPreferredSize();
		} 
		else 
		{
			containerwidth = jsp.getSize();
		}
		int allwidth = jg_table.getIntercellSpacing().width;
		for (int j = 0; j < jg_table.getColumnCount(); j++) 
		{
			int max = 0;
			for (int i = 0; i < jg_table.getRowCount(); i++) 
			{
				int width = jg_table.getCellRenderer(i, j).getTableCellRendererComponent(jg_table,jg_table.
					getValueAt(i, j), false, false, i, j).getPreferredSize().width;
				if (width > max) 
				{
					max = width;
				}
			}
			int headerwidth = jg_table.getTableHeader().getDefaultRenderer().getTableCellRendererComponent(jg_table,
				jg_table.getColumnModel().getColumn(j).getIdentifier(), false, false, -1, j).getPreferredSize().width;
			max += headerwidth;
			jg_table.getColumnModel().getColumn(j).setPreferredWidth(max);
			allwidth += max + jg_table.getIntercellSpacing().width;
		}
		allwidth += jg_table.getIntercellSpacing().width;
		if (allwidth > containerwidth.width) 
		{
			jg_table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		} 
		else 
		{
			jg_table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		}
	}

	private void setTableStyle(JTable table)
	{
		DefaultTableCellRenderer r = (DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();
		r.setHorizontalAlignment(SwingConstants.CENTER);
		DefaultTableCellRenderer r1 = new DefaultTableCellRenderer();
		r1.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class,r);
	}

	private Vector<List<String>> getVect() 
	{
		return vect;
	}
	
	private JTable getJg_table() 
	{
		return jg_table;
	}
}