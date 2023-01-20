package UI01.Controller;

import javax.swing.JInternalFrame;

import UI01.View.MainFrame;

public class GeneralMainFrameOperations {
	private MainFrame frame;
	private GeneralStockCartOperations generalStockCartOperations;
	private GeneralStockCartListOperations generalStockCartListOperations;
	public GeneralMainFrameOperations(MainFrame frame, GeneralStockCartListOperations generalStockCartListOperations, GeneralStockCartOperations generalStockCartOperations) {
		this.frame = frame;
		this.generalStockCartListOperations = generalStockCartListOperations;
		this.generalStockCartOperations = generalStockCartOperations;
	}
	
	public void setCurrentInternalFrame(JInternalFrame internalFrame){		
		if(!(frame.getInternalFrame() == null))
			frame.getInternalFrame().dispose();
		frame.setInternalFrame(internalFrame);
		frame.getInternalFrame().setBounds(0, 0, 900, 500);
		frame.getContentPane().add(frame.getInternalFrame());
		frame.getInternalFrame().setVisible(true);
	}
	
	public GeneralStockCartListOperations getGeneralStockCartListOperations() {
		return this.generalStockCartListOperations;
	}
	
	public GeneralStockCartOperations getGeneralStockCartOperations() {
		return this.generalStockCartOperations;
	}
}
