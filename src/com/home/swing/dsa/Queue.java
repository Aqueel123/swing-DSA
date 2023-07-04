package com.home.swing.dsa;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Queue extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Container contanuer;

	private JLabel title;
	private JLabel label;
	private JLabel queueSizeLable;
	private JButton push;
	private JButton pop;

	JTextField input;
	JTextField queueSizeInput;
	JButton jb1;

	int[] queue;
	private int index = 0;

	public Queue() {
		setTitle("DSA Queue");
		setBounds(100, 90, 300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		contanuer = getContentPane();
		contanuer.setLayout(null);

		title = new JLabel("DSA Queue");
		title.setSize(80, 10);
		title.setLocation(100, 10);
		contanuer.add(title);

		label = new JLabel();
		label.setText("");
		label.setSize(100, 20);
		label.setLocation(120, 20);
		contanuer.add(label);

		input = new JTextField();
		input.setSize(80, 30);
		input.setLocation(100, 50);
		contanuer.add(input);

		queueSizeLable = new JLabel("Please enter queue size");
		queueSizeLable.setForeground(Color.RED);
		queueSizeLable.setSize(150, 20);
		queueSizeLable.setLocation(80, 80);
		contanuer.add(queueSizeLable);

		push = new JButton("Enter");
		push.setSize(80, 20);
		push.setLocation(100, 100);
		contanuer.add(push);
		push.addActionListener(this);
		
		pop = new JButton("Pop");
		pop.setSize(80, 20);
		pop.setLocation(190, 100);
		pop.hide();
		contanuer.add(pop);
		
		setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionName = e.getActionCommand();

		if (actionName.equalsIgnoreCase("Enter")) {
			String value = input.getText();
			if ((!"".equals(value)) && !value.equals(null)) {
				int size = Integer.parseInt(input.getText());
				createQueue(size);
			} else {
				JOptionPane.showMessageDialog(this, "Queue size shouldn't be empty");
			}
		}

		if (actionName.equalsIgnoreCase("Push")) {
			String value = input.getText();
			if ((!"".equals(value)) && !value.equals(null)) {
				int passedInput = Integer.parseInt(value);
				push(passedInput);
			} else {
				JOptionPane.showMessageDialog(this, "Queue size shouldn't be empty");
			}
		}
		System.out.println("Queue.actionPerformed()" + actionName);
	}

	public void createQueue(int size) {
		queue = new int[size];
		push.setLabel("Push");
		input.setText("");
		queueSizeLable.setText("Queue size is - " + size);
		pop.show();
	}

	public void push(int num) {
		if (queue.length > 0 && queue.length != index) {
			queue[index] = num;
			displayQueue();
		} else {
			JOptionPane.showMessageDialog(this, "Queue is empty");
		}
	}

	public void displayQueue() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i <= index; i++) {
			sb.append(queue[i]+ " ");
		}
		System.out.println("Sb = "+ sb);
		label.setText(sb.toString());
		index += 1;
		input.setText("");
	}
	
	public void pop() {
		int removedItem = queue[0];
		for (int i = 0; i <= queue.length; i++) {
			
		}
	}

	public static void main(String[] args) {
		Queue queue = new Queue();
	}
}
