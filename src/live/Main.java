package live;
import java.io.*;
import java.util.*;
import static utils.Base.*;

class Formula {
    Scanner in = new Scanner(System.in);
    int id;
    String expression;
    String type;
    String category;
    ArrayList<String> key;

    Formula(int id, String ex, String type, String category) {
        this.id = id;
        this.expression = ex;
        this.type = type;
        this.category = category;
        key = new ArrayList<>();

    }

    void addKeywords() {
        int count = 1;

        while (true) {
            pl("Enter Keyword " + count + ":");
            count++;
            String s = in.nextLine().trim().replace(" ", "").toLowerCase();
            if (s.isEmpty())
                continue;
            this.key.add(s);
            pl("1-Add more keyword\n2-Exit ");
            if (in.nextInt() == 1) {
                in.nextLine();
                continue;
            } else {
                return;
            }

        }
    }

    void plKeywords() {
        p("Keyword - {");
        for (int i = 0; i < key.size(); i++) {
            if (i != key.size() - 1) {
                p(key.get(i) + ", ");
            } else {
                p(key.get(i));
            }
        }
        pl("}");
    }

    void info() {
        p("Id => " + this.id + " | ");
        p("Expression => " + this.expression + " | ");
        p("Type => " + this.type + " | ");
        pl("Category => " + this.category + " |");
    }

}

class Database {
    Scanner in = new Scanner(System.in);
    ArrayList<Formula> database = new ArrayList<>();


    // @working 
    
    void load()
    {
        if((new File("Formula_database")).exists())
        {
            try(BufferedReader br = new BufferedReader(new FileReader("Formula_database.txt")))
            {
                String line;
                
                while((line=br.readLine())!=null)
                {
                    int id; 
                    String expression , type, category ; 
                    ArrayList<String> keywords=new ArrayList<>();
                    String temp1[]=line.split("\\|");
                    for(int i=0;i<temp1.length;i++)
                    {
                        String temp2[]=temp1[i].split(":");
                          
                    }
                }
            }
            catch(IOException e)
            {

            }
        }
    }

    int lastIndex = database.size() - 1;

    void add() {
        pl("Enter Expression:");
        String ex = in.nextLine().replace(" ", "").toLowerCase();
        pl("Enter Type:");
        String ty = in.nextLine().replace(" ", "").toLowerCase();
        pl("Enter category:");
        String ca = in.nextLine().replace(" ", "").toLowerCase();
        Formula ob = new Formula(lastIndex + 1, ex, ty, ca);
        lastIndex++;

        p("Do you want to add more keywords? (y/n)");
        if (checkYN() == 0)
            ob.addKeywords();

        pl("Do you want to edit anything in this formula ? ");
        if (checkYN() == 0)
            edit(ob);
        database.add(ob);

        store(ob);
    }

    void search_Ex(String searchWord) {
        int count =0;
        pl("Search Results");
        for (int i = 0; i < database.size(); i++) {
            if (database.get(i).expression.contains(searchWord)) {
                pl(database.get(i).expression);
            }
        }
        if(count==0)
            pl("None !");
    }

    void search_Key(String searchWord) {
        int count =0;
        pl("Search Results");
        for (int i = 0; i < database.size(); i++) {
            for (int j = 0; j < database.get(i).key.size(); j++) {
                if (database.get(i).key.get(j).contains(searchWord)) {
                    database.get(i).info(); count ++;
                }
            }
        }
        if(count==0)
            pl("None !");
    }

    void list() { // Id => 1 | Expression => sin2x=2sinxcosx | Type => identity | Category =>
                  // double angle |
        for (int i = 0; i < database.size(); i++) {
            database.get(i).info();
        }
    }

    /*
     * void list(int type)
     * {
     * String cat;int flag =0;int flag2=0;
     * 
     * switch(type)
     * {
     * case 1: flag =1;cat="type"; break;
     * case 2: flag=2; cat="category"; break;
     * 
     * default : cat=""; break;
     * }
     * pl("Enter "+cat+":");
     * 
     * String s=in.nextLine();
     * for(int i=0;i<database.size();i++)
     * {
     * if(flag==1)
     * {
     * if(database.get(i).type.equalsIgnoreCase(cat))
     * {
     * System.out.println(database.get(i).expression); flag2++;
     * }
     * 
     * }
     * else if(flag==2)
     * 
     * {
     * if(database.get(i).category.equalsIgnoreCase(cat))
     * {
     * System.out.println(database.get(i).expression); flag2++;
     * }
     * 
     * }
     * 
     * 
     * }
     * if(flag2==0)
     * pl(cat+" Not Found");
     * 
     * }
     * 
     */

    void edit(Formula ob) 
    {
        // code here
    }

   

    void store(Formula ob) {
        // code here
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Database db = new Database();

        while (true) {
            System.out.println("1. Add Formula\n2. Search\n3. List All\n4. Edit Keywords\n5. Exit");
            int choice = in.nextInt();
            in.nextLine();

            if (choice == 3) {
                db.list();
            } else if (choice == 5) {
                break;
            }

        }
        in.close();
    }

}
