package builder.controllers;

import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.SixesWild;
import builder.model.BuilderSixesWild;
import builder.views.BuilderPanel;

/**
 * 
 * @author katiegandomi, Paulo
 *
 */
public class SliderController implements ChangeListener {

	/** Create Boundary Object */
	BuilderPanel builderPanel;
	
	/** Create Game Model Object*/
	BuilderSixesWild builder;
	
	/** Create Game Model Object*/
	SixesWild model;
	
	/** Array of sliders */
	JSlider sliders[];
	
	/**
	 * Constructor
	 * 
	 * @param builderPanel
	 * @param builder
	 * @param model
	 * @param sliders
	 */
	public SliderController(BuilderPanel builderPanel, BuilderSixesWild builder, SixesWild model, JSlider sliders[]){
		this.builderPanel = builderPanel;
		this.builder = builder;
		this.model = model;
		this.sliders = sliders;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		
		this.builder.createMemento(this.model.getBoard()); // Create memento
		
		for (int i=0; i<5; i++){
			if (e.getSource() == this.sliders[i]){
				this.model.getBoard().setFrequency(i, this.sliders[i].getValue());
			}
		}
		
		
		
	}
	
	
}
