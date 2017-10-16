import java.awt.Desktop;
import java.io.*;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

import javax.swing.text.AttributeSet;
import javax.swing.text.ElementIterator;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Bing {

	public static void main(String []args) throws Exception{
		
		if(args[2].equalsIgnoreCase("-o")){
			if(args.length<4){
			if(args[0].equalsIgnoreCase("-q")){
				Desktop d= Desktop.getDesktop();
				d.browse(new URI(args[1]));
				Document doc = Jsoup.connect(args[1]).userAgent("Mozilla").get();
				String title = doc.title();
				System.out.println(title);
			
				
					Elements urls= doc.getElementsByClass("b_algo");
			
	
				urls=urls.select("h2 a");
						
			
					//System.out.println(urls.get(i-6).attr("href"));
			
				int i=0;
				String array[]=new String[10];
				for(Element url :urls){
					System.out.println("href is :"+url.attr("href")+"\n");
					
					array[i]=url.attr("href");
					i++;
					
					//System.out.println("href is:-"+url.text());
				}
				
				String file=args[3];
				FileWriter fw= new FileWriter(file);
				BufferedWriter bw=new BufferedWriter(fw);
				PrintWriter fileout=new PrintWriter(bw);
				for(int k=0;k<5;k++){
					fileout.println(array[k]);

				}
				fileout.close();
				fw.close();
				
			}
			if(args[0].equalsIgnoreCase("-f")){
				File input = new File(args[1]);
				Document doc = Jsoup.parse(input, "UTF-8");
	
			    
				//String title = doc.title();
				//System.out.println(title);
			
				
					Elements urls= doc.getElementsByClass("b_algo");
					urls=urls.select("h2 a");
				int i=0;
				String array[]=new String[10];
				for(Element url :urls){
					//System.out.println("href is :"+url.attr("href")+"\n");
					
					array[i]=url.attr("href");
					i++;
					
				}
			
				String file=args[3];
				FileWriter fw= new FileWriter(file);
				BufferedWriter bw=new BufferedWriter(fw);
				PrintWriter fileout=new PrintWriter(bw);
				for(int k=0;k<5;k++){
					fileout.println(array[k]);

				}
				fileout.close();
				fw.close();
			}
		}
			else{
				File input = new File(args[5]);
				Document doc = Jsoup.parse(input, "UTF-8");
	
			    
				//String title = doc.title();
				//System.out.println(title);
			
				
					Elements urls= doc.getElementsByClass("b_algo");
					urls=urls.select("h2 a");
				int i=0;
				String array[]=new String[10];
				for(Element url :urls){
					//System.out.println("href is :"+url.attr("href")+"\n");
					
					array[i]=url.attr("href");
					i++;
					
				}
			
				String file=args[3];
				FileWriter fw= new FileWriter(file);
				BufferedWriter bw=new BufferedWriter(fw);
				PrintWriter fileout=new PrintWriter(bw);
				for(int k=0;k<5;k++){
					fileout.println(array[k]);

				}
				fileout.close();
				fw.close();
			}
		}
		else{
			System.out.println("No output file");
			System.exit(0);
		}
			
	}
}
