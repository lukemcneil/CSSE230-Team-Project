package Graph;

import java.awt.*;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.Hashtable;

public class GraphMaker {

	private Graph g;

	public static void main(String[] args) throws Exception {
		write(drawOlin2().nodes, "XML-data/olin2.xml");
		write(drawTestGraph().nodes, "XML-data/test.xml");
		write(drawOlin1().nodes, "XML-data/olin1.xml");
		write(drawOlin12().nodes, "XML-data/olin12.xml");
		write(drawMoenchLower1().nodes, "XML-data/MoenchLower1.xml");
		write(drawOlinMoench().nodes, "XML-data/OlinMoench.xml");
	}

	private static void addEdge(Node node1, Node node2, int cost) {
		node1.addEdge(node2, cost);
		node2.addEdge(node1, cost);
	}

	private static void write(Hashtable<String, Node> nodes, String filename) throws Exception {
		XMLEncoder encoder =
				new XMLEncoder(
						new BufferedOutputStream(
								new FileOutputStream(filename)));
		encoder.writeObject(nodes);
		encoder.close();
	}

	private static Graph drawOlin2() {
		Graph Olin2 = new Graph();
		String[] names = {"TopStairsO269", "O269", "O267", "TopStairsOCommons", "O259", "O257", "O225Corner", "O222", "O227", "O229", "O226", "O231", "O233", "OTopHadCommons", "TopStairsO238", "O201", "O203", "O202", "O204", "O203-1", "O205", "O206", "O207Corner", "TopStairsO214"};
		Point[] points = {new Point(65, 150), new Point(65, 135), new Point(65, 120), new Point(70, 110), new Point(85, 105), new Point(105, 105), new Point(145, 105), new Point(155, 105), new Point(165, 105), new Point(175, 105), new Point(185, 105), new Point(195, 105), new Point(205, 105), new Point(205, 140), new Point(210, 125), new Point(205, 160), new Point(195, 160), new Point(185, 160), new Point(175, 160), new Point(165, 160), new Point(157, 160), new Point(150, 160), new Point(145, 160), new Point(145, 130)};
		for (int i = 0; i < names.length; i++) {
			Olin2.addNode(names[i], points[i]);
		}
		Olin2.nodes.get("O269").setImage("RoomInfo/O269Image.png");
		Olin2.nodes.get("O225Corner").showName = false;
		Olin2.nodes.get("O207Corner").showName = false;
		Olin2.addEdge("TopStairsO269", "O269", 10);
		Olin2.addEdge("O269", "O267", 10);
		Olin2.addEdge("O267", "TopStairsOCommons", 30);
		Olin2.addEdge("TopStairsOCommons", "O259", 30);
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
		String[] names = {"BotStairsO269", "O169", "O167", "BotStairsOCommons", "Bot2ndStair", "O159", "O157", "O111", "O106", "O108", "O113", "O110", "O115", "O115Corner", "OBotHadCommons", "BotStairs238", "O101", "O103", "O105", "O107", "O102", "O102-1", "O109Corner", "O104", "BotStairsO104"};
		Point[] points = {new Point(65, 150+h), new Point(65, 135+h), new Point(65, 120+h),new Point(65, 105+h), new Point(70, 110+h), new Point(85, 105+h), new Point(105, 105+h), new Point(145, 105+h), new Point(155, 105+h), new Point(165, 105+h), new Point(175, 105+h), new Point(185, 105+h), new Point(195, 105+h), new Point(205, 105+h), new Point(205, 140+h), new Point(210, 125+h), new Point(205, 160+h), new Point(195, 160+h), new Point(185, 160+h), new Point(175, 160+h), new Point(165, 160+h), new Point(157, 160+h), new Point(145, 160+h), new Point(145, 140+h), new Point(145, 130+h)};
		for (int i =0;i<names.length;i++) {
			Olin1.addNode(names[i],points[i]);
		}

		Olin1.addEdge("BotStairsO269", "O169", 10);
		Olin1.addEdge("O169", "O167", 10);
		Olin1.addEdge("O167", "Bot2ndStair", 30);
		Olin1.addEdge("BotStairsOCommons", "Bot2ndStair", 10);
		Olin1.addEdge("Bot2ndStair", "O159", 30);
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
	
	private static Graph drawOlin12() {
		Graph Olin1 = new Graph();
		int h = 100;
		int m = 10;
		String[] names = {"BotStairsO269", "O169", "O167", "BotStairsOCommons", "Bot2ndStair", "O159", "O157", "O111", "O106", "O108", "O113", "O110", "O115", "O115Corner", "OBotHadCommons", "BotStairs238", "O101", "O103", "O105", "O107", "O102", "O102-1", "O109Corner", "O104", "BotStairsO104"};
		Point[] points = {new Point(65+m, 150+h), new Point(65+m, 135+h), new Point(65+m, 120+h),new Point(65+m, 105+h), new Point(70+m, 110+h), new Point(85+m, 105+h), new Point(105+m, 105+h), new Point(145+m, 105+h), new Point(155+m, 105+h), new Point(165+m, 105+h), new Point(175+m, 105+h), new Point(185+m, 105+h), new Point(195+m, 105+h), new Point(205+m, 105+h), new Point(205+m, 140+h), new Point(210+m, 125+h), new Point(205+m, 160+h), new Point(195+m, 160+h), new Point(185+m, 160+h), new Point(175+m, 160+h), new Point(165+m, 160+h), new Point(157+m, 160+h), new Point(145+m, 160+h), new Point(145+m, 140+h), new Point(145+m, 130+h)};
		for (int i =0;i<names.length;i++) {
			Olin1.addNode(names[i],points[i]);
		}

		Olin1.addEdge("BotStairsO269", "O169", 10);
		Olin1.addEdge("O169", "O167", 10);
		Olin1.addEdge("O167", "Bot2ndStair", 30);
		Olin1.addEdge("BotStairsOCommons", "Bot2ndStair", 10);
		Olin1.addEdge("Bot2ndStair", "O159", 30);
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
		Olin1.addEdge("OBotHadCommons", "O101", 15);
		Olin1.addEdge("O101", "O103", 20);
		Olin1.addEdge("O103", "O105", 10);
		Olin1.addEdge("O105", "O107", 20);
		Olin1.addEdge("O107", "O102", 10);
		Olin1.addEdge("O102", "O102-1", 10);
		Olin1.addEdge("O102-1", "O109Corner", 10);
		Olin1.addEdge("O109Corner", "O104", 10);
		Olin1.addEdge("O104", "BotStairsO104", 10);

		
		String[] names1 = {"TopStairsO269", "O269", "O267", "TopStairsOCommons", "O259", "O257", "O225Corner", "O222", "O227", "O229", "O226", "O231", "O233", "OTopHadCommons", "TopStairsO238", "O201", "O203", "O202", "O204", "O203-1", "O205", "O206", "O207Corner", "TopStairsO214"};
		Point[] points1 = {new Point(65, 150), new Point(65, 135), new Point(65, 120), new Point(70, 110), new Point(85, 105), new Point(105, 105), new Point(145, 105), new Point(155, 105), new Point(165, 105), new Point(175, 105), new Point(185, 105), new Point(195, 105), new Point(205, 105), new Point(205, 140), new Point(210, 125), new Point(205, 160), new Point(195, 160), new Point(185, 160), new Point(175, 160), new Point(165, 160), new Point(157, 160), new Point(150, 160), new Point(145, 160), new Point(145, 130)};
		for (int i = 0; i < names1.length; i++) {
			Olin1.addNode(names1[i], points1[i]);
		}
		Olin1.nodes.get("O269").setImage("RoomInfo/O269Image.png");
		Olin1.nodes.get("O225Corner").showName = false;
		Olin1.nodes.get("O207Corner").showName = false;
		Olin1.addEdge("TopStairsO269", "O269", 10);
		Olin1.addEdge("O269", "O267", 10);
		Olin1.addEdge("O267", "TopStairsOCommons", 30);
		Olin1.addEdge("TopStairsOCommons", "O259", 30);
		Olin1.addEdge("O259", "O257", 10);
		Olin1.addEdge("O257", "O225Corner", 40);
		Olin1.addEdge("O225Corner", "O222", 20);
		Olin1.addEdge("O225Corner", "TopStairsO214", 20);
		Olin1.addEdge("O222", "O227", 10);
		Olin1.addEdge("O227", "O229", 10);
		Olin1.addEdge("O229", "O226", 10);
		Olin1.addEdge("O226", "O231", 30);
		Olin1.addEdge("O231", "O233", 20);
		Olin1.addEdge("O233", "OTopHadCommons", 20);
		Olin1.addEdge("OTopHadCommons", "TopStairsO238", 15);
		Olin1.addEdge("OTopHadCommons", "O201", 20);
		Olin1.addEdge("O201", "O203", 10);
		Olin1.addEdge("O203", "O202", 20);
		Olin1.addEdge("O202", "O204", 10);
		Olin1.addEdge("O204", "O203-1", 10);
		Olin1.addEdge("O203-1", "O205", 10);
		Olin1.addEdge("O205", "O206", 10);
		Olin1.addEdge("O206", "O207Corner", 10);
		Olin1.addEdge("O207Corner", "TopStairsO214", 20);
		
		Olin1.addEdge("TopStairsO214", "BotStairsO104", 10);
		Olin1.addEdge("TopStairsO238", "BotStairs238",10);
		Olin1.addEdge("BotStairsOCommons", "TopStairsOCommons", 10);
		Olin1.addEdge("TopStairsO269", "BotStairsO269", 10);
		
		return Olin1;
	}
	
	private static Graph drawMoenchLower1() {
		Graph MoenchLower1 = new Graph();
		String[] names = {"CommonsEntrance","ELCorner","FL101Corner","FL104Ent","FL104","FL106Ent","FL106","FLFromCom","FL1062nd","DLCorner","DL115","DL117","DL119","DLCorner2","DL101","CL117Ent","CL117","CL119","BL110","BL112","BL108","BL113","BL114","BLCorner"};
		int x =300;
		int y =-20;
		int m =2;
		Point[] points = {new Point(10*m+x,30*m+y),new Point(40*m+x,30*m+y),new Point(40*m+x,10*m+y),new Point(35*m+x,10*m+y),new Point(35*m+x,5*m+y), new Point(15*m+x,10*m+y),new Point(15*m+x,5*m+y), new Point(10*m+x,10*m+y), new Point(10*m+x,5*m+y), new Point(40*m+x,50*m+y),new Point(30*m+x,50*m+y), new Point(30*m+x,52*m+y), new Point(35*m+x,52*m+y),new Point(40*m+x,52*m+y),new Point(45*m+x,52*m+y), new Point(40*m+x,72*m+y),new Point(38*m+x,72*m+y),new Point(40*m+x,82*m+y),new Point(40*m+x,87*m+y),new Point(40*m+x,92*m+y),new Point(40*m+x,94*m+y),new Point(35*m+x,94*m+y),new Point(35*m+x,96*m+y),new Point(40*m+x,96*m+y)};
		for(int i =0;i<names.length;i++) {
			MoenchLower1.addNode(names[i],points[i]);
		}
		MoenchLower1.nodes.get("ELCorner").showName=false;
		MoenchLower1.nodes.get("FL101Corner").showName=false;
		MoenchLower1.nodes.get("FL104Ent").showName=false;
		MoenchLower1.nodes.get("FL106Ent").showName=false;
		MoenchLower1.nodes.get("FLFromCom").showName=false;
		MoenchLower1.nodes.get("DLCorner").showName=false;
		MoenchLower1.nodes.get("DLCorner2").showName=false;
		MoenchLower1.nodes.get("CL117Ent").showName=false;
		MoenchLower1.nodes.get("BLCorner").showName=false;
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
		
		return MoenchLower1;
	}
	
	private static Graph drawOlinMoench() {
		Graph sol = drawOlin12();
		Graph temp = drawMoenchLower1();
		for(String c : temp.nodes.keySet()) {
			sol.nodes.put(c, temp.nodes.get(c));
		}
		return sol;
	}
	
	private static Graph drawMoench1() {
		Graph Moench1 = new Graph();
		
		
		return Moench1;
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