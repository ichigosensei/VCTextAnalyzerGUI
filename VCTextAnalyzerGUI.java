//Created By: Trinidad, Strawberry Ann
//Subject: CEN-3024C Software Development I
//Date: March 23, 2022

package Module2;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javax.swing.*;

import java.awt.*;

@SuppressWarnings("serial")
public class VCTextAnalyzerGUI extends JFrame implements ActionListener {
	
	JLabel openingMessage, instructions;
	JButton analyzeInput;
	JTextArea inputText, frequencyList;
	JScrollPane inputArea, resultsArea;
	
	VCTextAnalyzerGUI () {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200,1200);
		this.setTitle("VC Text Analyzer");
		this.setLayout(null);
		this.setVisible(true);
		
		inputText = new JTextArea("Please paste/type the text here...");
		inputText.setBounds(50, 150, 300, 300);
		inputText.setLineWrap(true);
		inputText.setMargin(new Insets(10,10,10,10));
		this.add(inputText);
		
		frequencyList = new JTextArea("Results will be printed here...");
		frequencyList.setBounds(600,150,500,500);
		frequencyList.setLineWrap(true);
		frequencyList.setMargin(new Insets(10,10,10,10));
		this.add(frequencyList);
		
		inputArea = new JScrollPane(inputText);
		inputArea.setBounds(50,150,500,500);
		
		resultsArea = new JScrollPane(frequencyList);
		resultsArea.setBounds(600,150,500,500);
		
		openingMessage = new JLabel("- VALENCIA TEXT ANALYZER -");
		openingMessage.setBounds(475,25,200,50);
		instructions = new JLabel("You may now copy and paste or type the text you want to be analyzed below.");
		instructions.setBounds(315,60,500,50);
		
		analyzeInput = new JButton("ANALYZE");
		analyzeInput.setBounds(475,675,200,50);
		analyzeInput.addActionListener(this);
		
		this.add(openingMessage);
		this.add(instructions);
		this.add(analyzeInput);
		this.add(inputArea);
		this.add(resultsArea);
		
	}

		//This function prints out the frequency of each word that is pasted/typed into the input area of the program
				@Override
				public void actionPerformed(java.awt.event.ActionEvent e) { 
					String userArea = inputText.getText();
					try (Scanner userInput = new Scanner(userArea)) {
						Map<String, Integer> wordFrequency = new HashMap<>();
						
						while (userInput.hasNext()) {
							String word = userInput.next();
							if(wordFrequency.containsKey(word) == false)
								wordFrequency.put(word,1);
							else {
								int count = (int)(wordFrequency.get(word));
								wordFrequency.remove(word);
								wordFrequency.put(word, count + 1);
								
								}
							
					        }
						
						frequencyList.setText("The following words have been analyzed: \n" + "\n" + wordFrequency);
					}
				}
				
			//Enables the program to run
			public static void main(String[] args) {
				new VCTextAnalyzerGUI();
				
				}	
		}
