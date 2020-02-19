package Graph;

import java.awt.*;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Hashtable;

public class GraphMaker {

	private Graph g;

	public static void main(String[] args) throws Exception {
//		write(drawOlin2().nodes, "XML-data/olin2.xml");
//		write(drawTestGraph().nodes, "XML-data/test.xml");
//		write(drawOlin1().nodes, "XML-data/olin1.xml");
//		write(drawOlin12().nodes, "XML-data/olin12.xml");
//		write(drawMoenchLower1().nodes, "XML-data/MoenchLower1.xml");
		write(drawOlinMoench().nodes, "XML-data/OlinMoench.xml");
//		write(drawMoench1().nodes, "XML-data/Moench1.xml");
//		write(drawMoench2().nodes, "XML-data/Moench2.xml");
	}

	private static void addEdge(Node node1, Node node2, int cost) {
		node1.addEdge(node2, cost);
		node2.addEdge(node1, cost);
	}

	private static void write(Hashtable<String, Node> nodes, String filename) throws Exception {
		XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filename)));
		encoder.writeObject(nodes);
		encoder.close();
	}

	private static Graph drawOlin2() {
		Graph Olin2 = new Graph();
		int y = 100;
		String[] names = {"TopStairsO269", "O269", "O267", "TopStairsOCommons", "O2Elevator", "O259", "O257",
				"O225Corner", "O222", "O227", "O229", "O226", "O231", "O233", "OTopHadCommons", "TopStairsO238", "O201",
				"O203", "O202", "O204", "O203-1", "O205", "O206", "O207Corner", "TopStairsO214", "O2Elevator2"};
		Point[] points = {new Point(65, 150 + y), new Point(65, 135 + y), new Point(65, 120 + y),
				new Point(70, 110 + y), new Point(74, 107 + y), new Point(85, 105 + y), new Point(105, 105 + y),
				new Point(145, 105 + y), new Point(155, 105 + y), new Point(165, 105 + y), new Point(175, 105 + y),
				new Point(185, 105 + y), new Point(195, 105 + y), new Point(205, 105 + y), new Point(205, 140 + y),
				new Point(210, 125 + y), new Point(205, 160 + y), new Point(195, 160 + y), new Point(185, 160 + y),
				new Point(175, 160 + y), new Point(165, 160 + y), new Point(157, 160 + y), new Point(150, 160 + y),
				new Point(145, 160 + y), new Point(145, 130 + y), new Point(210, 130 + y)};
		for (int i = 0; i < names.length; i++) {
			Olin2.addNode(names[i], points[i], 2);
		}
		for (String i : Olin2.nodes.keySet()) {
			Olin2.nodes.get(i).setImage("RoomInfo" + File.separator + "Olin 2" + File.separator + i + "Image.PNG");
		}
		Olin2.nodes.get("O225Corner").showName = false;
		Olin2.nodes.get("O207Corner").showName = false;
		Olin2.addEdge("TopStairsO269", "O269", 10);
		Olin2.addEdge("O269", "O267", 10);
		Olin2.addEdge("O267", "TopStairsOCommons", 30);
		Olin2.addEdge("TopStairsOCommons", "O2Elevator", 10);
		Olin2.addEdge("O259", "O2Elevator", 20);
		Olin2.addEdge("O259", "O257", 10);
		Olin2.addEdge("O257", "O225Corner", 40);
		Olin2.addEdge("O225Corner", "O222", 20);
		Olin2.addEdge("O225Corner", "TopStairsO214", 20);
		Olin2.addEdge("O222", "O227", 10);
		Olin2.addEdge("O227", "O229", 10);
		Olin2.addEdge("O229", "O226", 10);
		Olin2.addEdge("O226", "O231", 30);
		Olin2.addEdge("O231", "O233", 20);
		Olin2.addEdge("O233", "OTopHadCommons", 20);
		Olin2.addEdge("OTopHadCommons", "TopStairsO238", 15);
		Olin2.addEdge("OTopHadCommons", "O2Elevator2", 15);
		Olin2.addEdge("OTopHadCommons", "O201", 20);
		Olin2.addEdge("O201", "O203", 10);
		Olin2.addEdge("O203", "O202", 20);
		Olin2.addEdge("O202", "O204", 10);
		Olin2.addEdge("O204", "O203-1", 10);
		Olin2.addEdge("O203-1", "O205", 10);
		Olin2.addEdge("O205", "O206", 10);
		Olin2.addEdge("O206", "O207Corner", 10);
		Olin2.addEdge("O207Corner", "TopStairsO214", 20);

		System.out.println("added olin2.xml");
		return Olin2;
	}

	private static Graph drawOlin1() {
		Graph Olin1 = new Graph();
		int h = 100;
		String[] names = {"BotStairsO269", "O169", "O167", "BotStairsOCommons", "Bot2ndStair", "O1Elevator", "O159",
				"O157", "O111", "O106", "O108", "O113", "O110", "O115", "O115Corner", "OBotHadCommons", "BotStairs238", "O1Elevator2",
				"O101", "O103", "O105", "O107", "O102", "O102-1", "O109Corner", "O104", "BotStairsO104"};
		Point[] points = {new Point(65, 150 + h), new Point(65, 135 + h), new Point(65, 120 + h),
				new Point(65, 105 + h), new Point(70, 110 + h), new Point(73, 107 + h), new Point(85, 105 + h),
				new Point(105, 105 + h), new Point(145, 105 + h), new Point(155, 105 + h), new Point(165, 105 + h),
				new Point(175, 105 + h), new Point(185, 105 + h), new Point(195, 105 + h), new Point(205, 105 + h),
				new Point(205, 140 + h), new Point(210, 125 + h), new Point(210, 130 + h), new Point(205, 160 + h), new Point(195, 160 + h),
				new Point(185, 160 + h), new Point(175, 160 + h), new Point(165, 160 + h), new Point(157, 160 + h),
				new Point(145, 160 + h), new Point(145, 140 + h), new Point(145, 130 + h)};
		for (int i = 0; i < names.length; i++) {
			Olin1.addNode(names[i], points[i], 1);
		}

		for (String i : Olin1.nodes.keySet()) {
			Olin1.nodes.get(i).setImage("RoomInfo" + File.separator + "Olin 1" + File.separator + i + "Image.PNG");
		}

		Olin1.addEdge("BotStairsO269", "O169", 10);
		Olin1.addEdge("O169", "O167", 10);
		Olin1.addEdge("O167", "Bot2ndStair", 30);
		Olin1.addEdge("BotStairsOCommons", "Bot2ndStair", 10);
		Olin1.addEdge("Bot2ndStair", "O1Elevator", 10);
		Olin1.addEdge("O159", "O1Elevator", 20);
		Olin1.addEdge("O159", "O157", 10);
		Olin1.addEdge("O157", "O111", 40);
		Olin1.addEdge("O111", "O106", 20);
		Olin1.addEdge("O111", "BotStairsO104", 30);
		Olin1.addEdge("O106", "O108", 10);
		Olin1.addEdge("O108", "O113", 10);
		Olin1.addEdge("O113", "O110", 10);
		Olin1.addEdge("O110", "O115", 30);
		Olin1.addEdge("O115", "O115Corner", 10);
		Olin1.addEdge("O115Corner", "OBotHadCommons", 20);
		Olin1.addEdge("OBotHadCommons", "BotStairs238", 20);
		Olin1.addEdge("OBotHadCommons", "O1Elevator2", 20);
		Olin1.addEdge("OBotHadCommons", "O101", 15);
		Olin1.addEdge("O101", "O103", 20);
		Olin1.addEdge("O103", "O105", 10);
		Olin1.addEdge("O105", "O107", 20);
		Olin1.addEdge("O107", "O102", 10);
		Olin1.addEdge("O102", "O102-1", 10);
		Olin1.addEdge("O102-1", "O109Corner", 10);
		Olin1.addEdge("O109Corner", "O104", 10);
		Olin1.addEdge("O104", "BotStairsO104", 10);

		return Olin1;
	}

	private static Graph drawMoench1() {
		Graph Moench1 = new Graph();
		int x = 300;
		int y = 60;
		int m = 1;
		String[] names = {"ToCrapo2", "F108", "F102Corner", "F101Corner", "E104", "E100Corner", "E101Corner",
				"Moench1Stairs", "DCorner", "D112", "D114", "D115", "DCorner2", "D101", "D105Corner", "C107Corner",
				"C111", "CCorner", "C116", "C115", "C114", "C112Corner", "B106", "B105Ent", "B105", "A102",
				"A124Corner", "A120Corner", "MElevatorN1", "MElevatorS1"};
		Point[] points = {new Point(1 * m + x, 10 * m + y), new Point(10 * m + x, 10 * m + y),
				new Point(40 * m + x, 10 * m + y), new Point(50 * m + x, 10 * m + y), new Point(50 * m + x, 20 * m + y),
				new Point(40 * m + x, 20 * m + y), new Point(40 * m + x, 40 * m + y), new Point(20 * m + x, 40 * m + y),
				new Point(40 * m + x, 60 * m + y), new Point(35 * m + x, 60 * m + y), new Point(33 * m + x, 60 * m + y),
				new Point(33 * m + x, 65 * m + y), new Point(40 * m + x, 65 * m + y), new Point(55 * m + x, 60 * m + y),
				new Point(60 * m + x, 60 * m + y), new Point(60 * m + x, 90 * m + y), new Point(55 * m + x, 90 * m + y),
				new Point(40 * m + x, 90 * m + y), new Point(30 * m + x, 90 * m + y), new Point(30 * m + x, 85 * m + y),
				new Point(30 * m + x, 80 * m + y), new Point(40 * m + x, 80 * m + y),
				new Point(40 * m + x, 120 * m + y), new Point(40 * m + x, 125 * m + y),
				new Point(45 * m + x, 125 * m + y), new Point(40 * m + x, 145 * m + y),
				new Point(10 * m + x, 145 * m + y), new Point(1 * m + x, 155 * m + y), new Point(45 * m + x, 35 * m + y), new Point(35 * m + x, 125 * m + y)};
		for (int i = 0; i < names.length; i++) {
			Moench1.addNode(names[i], points[i], 1);
		}

		Moench1.addEdge("ToCrapo2", "F108", 10);
		Moench1.addEdge("F108", "F102Corner", 15);
		Moench1.addEdge("F102Corner", "F101Corner", 10);
		Moench1.addEdge("F101Corner", "E104", 10);
		Moench1.addEdge("E104", "E100Corner", 10);
		Moench1.addEdge("E100Corner", "E101Corner", 10);
		Moench1.addEdge("F102Corner", "E100Corner", 10);
		Moench1.addEdge("E101Corner", "E101Corner", 15);
		Moench1.addEdge("E101Corner", "Moench1Stairs", 10);
		Moench1.addEdge("E101Corner", "DCorner", 15);
		Moench1.addEdge("DCorner", "D112", 10);
		Moench1.addEdge("D112", "D114", 5);
		Moench1.addEdge("D114", "D115", 5);
		Moench1.addEdge("D115", "DCorner2", 15);
		Moench1.addEdge("DCorner", "DCorner2", 5);
		Moench1.addEdge("DCorner2", "C112Corner", 25);
		Moench1.addEdge("DCorner", "D101", 15);
		Moench1.addEdge("D101", "D105Corner", 5);
		Moench1.addEdge("D105Corner", "C107Corner", 30);
		Moench1.addEdge("C107Corner", "C111", 10);
		Moench1.addEdge("C111", "CCorner", 15);
		Moench1.addEdge("CCorner", "C116", 10);
		Moench1.addEdge("C116", "C115", 5);
		Moench1.addEdge("C115", "C114", 5);
		Moench1.addEdge("C114", "C112Corner", 10);
		Moench1.addEdge("CCorner", "B106", 20);
		Moench1.addEdge("B106", "B105Ent", 2);
		Moench1.addEdge("B105Ent", "B105", 7);
		Moench1.addEdge("B105Ent", "A102", 15);
		Moench1.addEdge("A102", "A124Corner", 20);
		Moench1.addEdge("A124Corner", "A120Corner", 15);
		Moench1.addEdge("CCorner", "C112Corner", 10);
		Moench1.addEdge("MElevatorN1", "E101Corner", 10);
		Moench1.addEdge("B105Ent", "MElevatorS1", 10);

		return Moench1;
	}

	private static Graph drawMoench2() {
		Graph Moench2 = new Graph();
		int x = 300;
		int y = 60;
		int m = 1;
		String[] names = {"F235", "F230", "F222", "F218", "F210", "E200", "Moench2Stairs", "E104-2", "MElevatorN2", "B200", "MElevatorS2", "A223",
				"A209", "A202", "A220", "A219", "A217"};
		Point[] points = {new Point(10 * m + x, 10 * m + y), new Point(10 * m + x, 1 * m + y),
				new Point(40 * m + x, 1 * m + y), new Point(50 * m + x, 1 * m + y), new Point(70 * m + x, 1 * m + y),
				new Point(40 * m + x, 40 * m + y), new Point(30 * m + x, 40 * m + y), new Point(50 * m + x, 40 * m + y), new Point(45 * m + x, 35 * m + y),
				new Point(40 * m + x, 125 * m + y), new Point(35 * m + x, 125 * m + y), new Point(40 * m + x, 135 * m + y),
				new Point(40 * m + x, 145 * m + y), new Point(60 * m + x, 145 * m + y),
				new Point(30 * m + x, 145 * m + y), new Point(26 * m + x, 145 * m + y),
				new Point(8 * m + x, 145 * m + y)};
		for (int i = 0; i < names.length; i++) {
			Moench2.addNode(names[i], points[i], 2);
		}
		Moench2.addEdge("F235", "F230", 10);
		Moench2.addEdge("F222", "F230", 20);
		Moench2.addEdge("F222", "F218", 10);
		Moench2.addEdge("F210", "F218", 20);
		Moench2.addEdge("F222", "E200", 25);
		Moench2.addEdge("E104-2", "E200", 10);
		Moench2.addEdge("Moench2Stairs", "E200", 10);
		Moench2.addEdge("B200", "E200", 50);
		Moench2.addEdge("A223", "B200", 10);
		Moench2.addEdge("A223", "A209", 10);
		Moench2.addEdge("A202", "A209", 20);
		Moench2.addEdge("A220", "A209", 20);
		Moench2.addEdge("A220", "A219", 5);
		Moench2.addEdge("A219", "A217", 15);
		Moench2.addEdge("E200", "MElevatorN2", 10);
		Moench2.addEdge("B200", "MElevatorS2", 10);
		return Moench2;
	}

	private static Graph drawOlin12() {
		Graph ret = drawOlin1();
		Graph temp = drawOlin2();
		for (String c : temp.nodes.keySet()) {
			ret.nodes.put(c, temp.nodes.get(c));
		}
		ret.addEdge("BotStairsO269", "TopStairsO269", 10, "stairs");
		ret.addEdge("TopStairsOCommons", "BotStairsOCommons", 10, "stairs");
		ret.addEdge("TopStairsO238", "BotStairs238", 10, "stairs");
		ret.addEdge("TopStairsO214", "BotStairsO104", 10, "stairs");
		ret.addEdge("O1Elevator", "O2Elevator", 100, "elevator");
		ret.addEdge("O1Elevator2", "O2Elevator2", 100, "elevator");
		return ret;
	}

	private static Graph drawMoenchLower1() {
		Graph MoenchLower1 = new Graph();
		String[] names = {"CommonsEntrance", "ELCorner", "FL101Corner", "FL104Ent", "FL104", "FL106Ent", "FL106",
				"FLFromCom", "FL1062nd", "DLCorner", "DL115", "DL117", "DL119", "DLCorner2", "DL101", "CL117Ent",
				"CL117", "CL119", "BL110", "BL112", "BL108", "BL113", "BL114", "BLCorner", "MElevatorN0", "MElevatorS0"};
		int x = 250;
		int y = 50;
		int m = 2;
		Point[] points = {new Point(10 * m + x, 30 * m + y), new Point(40 * m + x, 30 * m + y),
				new Point(40 * m + x, 10 * m + y), new Point(35 * m + x, 10 * m + y), new Point(35 * m + x, 5 * m + y),
				new Point(15 * m + x, 10 * m + y), new Point(15 * m + x, 5 * m + y), new Point(10 * m + x, 10 * m + y),
				new Point(10 * m + x, 5 * m + y), new Point(40 * m + x, 50 * m + y), new Point(30 * m + x, 50 * m + y),
				new Point(30 * m + x, 52 * m + y), new Point(35 * m + x, 52 * m + y), new Point(40 * m + x, 52 * m + y),
				new Point(45 * m + x, 52 * m + y), new Point(40 * m + x, 72 * m + y), new Point(38 * m + x, 72 * m + y),
				new Point(40 * m + x, 82 * m + y), new Point(40 * m + x, 87 * m + y), new Point(40 * m + x, 92 * m + y),
				new Point(40 * m + x, 94 * m + y), new Point(35 * m + x, 94 * m + y), new Point(35 * m + x, 96 * m + y),
				new Point(40 * m + x, 96 * m + y), new Point(45 * m + x, 35 * m + y), new Point(38 * m + x, 70 * m + y)};
		for (int i = 0; i < names.length; i++) {
			MoenchLower1.addNode(names[i], points[i], 0);
		}
		for (String i : MoenchLower1.nodes.keySet()) {
			MoenchLower1.nodes.get(i)
					.setImage("RoomInfo" + File.separator + "Moench Lower Level" + File.separator + i + "Image.PNG");
		}

		MoenchLower1.nodes.get("ELCorner").showName = false;
		MoenchLower1.nodes.get("FL101Corner").showName = false;
		MoenchLower1.nodes.get("FL104Ent").showName = false;
		MoenchLower1.nodes.get("FL106Ent").showName = false;
		MoenchLower1.nodes.get("FLFromCom").showName = false;
		MoenchLower1.nodes.get("DLCorner").showName = false;
		MoenchLower1.nodes.get("DLCorner2").showName = false;
		MoenchLower1.nodes.get("CL117Ent").showName = false;
		MoenchLower1.nodes.get("BLCorner").showName = false;
		MoenchLower1.addEdge("CommonsEntrance", "ELCorner", 20);
		MoenchLower1.addEdge("ELCorner", "FL101Corner", 20);
		MoenchLower1.addEdge("FL101Corner", "FL104Ent", 10);
		MoenchLower1.addEdge("FL104", "FL104Ent", 5);
		MoenchLower1.addEdge("FL104Ent", "FL106Ent", 15);
		MoenchLower1.addEdge("FL106Ent", "FL106", 10);
		MoenchLower1.addEdge("FL106Ent", "FLFromCom", 10);
		MoenchLower1.addEdge("FLFromCom", "FL1062nd", 10);
		MoenchLower1.addEdge("CommonsEntrance", "FLFromCom", 20);
		MoenchLower1.addEdge("ELCorner", "DLCorner", 20);
		MoenchLower1.addEdge("DLCorner", "DL115", 15);
		MoenchLower1.addEdge("DLCorner", "DLCorner2", 5);
		MoenchLower1.addEdge("DL115", "DL117", 5);
		MoenchLower1.addEdge("DL117", "DL119", 10);
		MoenchLower1.addEdge("DL119", "DLCorner2", 5);
		MoenchLower1.addEdge("DLCorner2", "DL101", 5);
		MoenchLower1.addEdge("DLCorner2", "CL117Ent", 20);
		MoenchLower1.addEdge("CL117Ent", "CL117", 5);
		MoenchLower1.addEdge("CL117Ent", "CL119", 10);
		MoenchLower1.addEdge("CL119", "BL110", 10);
		MoenchLower1.addEdge("BL110", "BL112", 5);
		MoenchLower1.addEdge("BL112", "BL108", 2);
		MoenchLower1.addEdge("BL108", "BL113", 10);
		MoenchLower1.addEdge("BL113", "BL114", 5);
		MoenchLower1.addEdge("BL114", "BLCorner", 10);
		MoenchLower1.addEdge("BLCorner", "BL108", 5);
		MoenchLower1.addEdge("ELCorner", "MElevatorN0", 10);
		MoenchLower1.addEdge("MElevatorS0", "CL117Ent", 10);

		return MoenchLower1;
	}

	private static Graph drawMoench() {
		Graph result = new Graph();
		Graph moenchL = drawMoenchLower1();
		Graph moench1 = drawMoench1();
		Graph moench2 = drawMoench2();
		for (String c : moenchL.nodes.keySet()) {
			result.nodes.put(c, moenchL.nodes.get(c));
		}
		for (String c : moench1.nodes.keySet()) {
			result.nodes.put(c, moench1.nodes.get(c));
		}
		for (String c : moench2.nodes.keySet()) {
			result.nodes.put(c, moench2.nodes.get(c));
		}
		result.addEdge("CommonsEntrance", "Moench1Stairs", 10, "stairs");
		result.addEdge("Moench1Stairs", "Moench2Stairs", 10, "stairs");
		result.addEdge("MElevatorN0", "MElevatorN1", 100, "elevator");
		result.addEdge("MElevatorN1", "MElevatorN2", 100, "elevator");
		result.addEdge("MElevatorS0", "MElevatorS1", 100, "elevator");
		result.addEdge("MElevatorS1", "MElevatorS2", 100, "elevator");
		return result;
	}

	private static Graph drawOlinMoench() {
		Graph olin12 = drawOlin12();
		Graph moench = drawMoench();
		for (String c : moench.nodes.keySet()) {
			olin12.nodes.put(c, moench.nodes.get(c));
		}
		olin12.addEdge("A120Corner", "OBotHadCommons", 30);
		olin12.addEdge("A217", "OTopHadCommons", 30);

		return olin12;
	}

	private static Graph drawTestGraph() {
		Graph g = new Graph();

		Node n0 = new Node("n0");
		Node n1 = new Node("n1");
		Node n2 = new Node("n2");
		Node n3 = new Node("n3");
		Node n4 = new Node("n4");
		Node n5 = new Node("n5");
		Node n6 = new Node("n6");
		Node n7 = new Node("n7");

		addEdge(n0, n1, 3);
		addEdge(n0, n2, 5);

		addEdge(n1, n2, 6);
		addEdge(n1, n6, 1);

		addEdge(n2, n5, 7);
		addEdge(n2, n6, 7);

		addEdge(n3, n7, 2);

		addEdge(n4, n6, 7);
		addEdge(n4, n7, 7);

		addEdge(n5, n7, 1);

		addEdge(n6, n7, 7);

		g.nodes.put("n0", n0);
		g.nodes.put("n1", n1);
		g.nodes.put("n2", n2);
		g.nodes.put("n3", n3);
		g.nodes.put("n4", n4);
		g.nodes.put("n5", n5);
		g.nodes.put("n6", n6);
		g.nodes.put("n7", n7);
		System.out.println("added test.xml");

		return g;
	}
}