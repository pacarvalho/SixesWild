package builder.controllers;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import model.SixesWild;
import builder.model.BuilderSixesWild;
import builder.views.BuilderPanel;

/**
 * Listener for builder sliders.
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

	/**
	 * Slider stateChange Listener
	 * 
	 * Watches for changes in the sliders and makes the corresponding change to the
	 * frequencies
	 */
	@Override
	public void stateChanged(ChangeEvent e) {
		
		this.builder.createMemento(this.model.getBoard()); // Create memento
		
		for (int i=0; i<6; i++){
			//Probability of each type of multiplier
			if(e.getSource() == this.sliders[5]){
				this.model.getBoard().set2x3xFrequency(0, this.sliders[i].getValue());
				this.model.getBoard().set2x3xFrequency(1, this.sliders[i].getMaximum()-this.sliders[i].getValue());
			}
			
			// Probability of each type of tile
			else{
				this.model.getBoard().setFrequency(i, this.sliders[i].getValue());
			}
		}
		
		
		
	}
	
	
}
