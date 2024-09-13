package test;
//note for file name do not use the () it will not read
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.sql.rowset.spi.SyncFactoryException;

import javafx.application.Application;
import javafx.beans.binding.IntegerExpression;
import javafx.geometry.Insets;

import javafx.scene.Node;

import javafx.scene.Scene;

import javafx.scene.control.Button;

import javafx.scene.control.Label;

import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class testing extends Application {

    private String container1="";
    private TextField input;
    private List<String> operation=new ArrayList<String>();
   // private String text_input="";
    private String container2="";
    //private String operation=""; 
    private boolean check_oper=false;
    private Label result;
    private ArrayList<String> tracker=new ArrayList<>();
    private ArrayList<String> memory=new ArrayList<>();
    //private String screen_shot="";
    private Scene scene;

    public static void main(String[] args) {

        launch(args);

    }

    GridPane grid;



    @Override

    public void start(Stage primaryStage) {

        grid = new GridPane();



        //creates the elements of the calculator and gets places on the root pane

        setElementsOnCalculator();

        //takes the elements of the calculator and sizes and arranges them so they look nice

        spaceElementsOnCalculator();











         scene = new Scene(grid, 500, 400);
         keyboard();
        



        primaryStage.setTitle("Calculator");

        primaryStage.setScene(scene);

        primaryStage.show();



    }



    public void setElementsOnCalculator(){

        /**creates input and result elements and add to grid**/

        result = new Label("this is the result");

        input = new TextField("");

        //input.setDisable(true);

        input.setEditable(false);
        

        //add the result to grid with the following parameters:

        //node, columnIndex, rowIndex, columnSpan, rowSpan

        grid.add(result, 0, 0, 6, 1);





        //add the result to grid with the following parameters:

        //node, columnIndex, rowIndex, columnSpan, rowSpan

        grid.add(input, 0, 1, 6, 1);



        // Allow the element grow the set span (either on columns, rows, or both)

        GridPane.setColumnSpan(input, 6);

        input.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);



        /**creates buttons**/

        Button seven = new Button("7");
        seven.setOnAction(e->on_Number_Click("7"));

        Button eight = new Button("8");
        eight.setOnAction(e->on_Number_Click("8"));
        Button nine = new Button("9");
        nine.setOnAction(e->on_Number_Click("9"));
        Button multiply = new Button("x");
        multiply.setOnAction(e->onOperatorClick("x"));
        multiply.setStyle("-fx-background-color: #FF7586");

        Button percent = new Button("%");
        percent.setOnAction(e->onOperatorClick("%"));
        percent.setStyle("-fx-background-color: #FF7586");

        Button clear = new Button("Clear");
        clear.setOnAction(e-> onclear("Clear"));
        clear.setStyle("-fx-background-color: #FF7586");



        Button four = new Button("4");
        four.setOnAction(e-> on_Number_Click("4"));
        Button five = new Button("5");
        five.setOnAction(e-> on_Number_Click("5"));
        Button six = new Button("6");
        six.setOnAction(e-> on_Number_Click("6"));
        Button minus = new Button("-");
        minus.setOnAction(e-> onOperatorClick("-"));
        minus.setStyle("-fx-background-color: #FF7586");

        Button factorial = new Button("X!");
        factorial.setOnAction(e-> onspecial_case("X!"));
        factorial.setStyle("-fx-background-color: #FF7586");

        Button squared = new Button("X²");
        squared.setOnAction(e-> onspecial_case("X²"));
        squared.setStyle("-fx-background-color: #FF7586");



        Button one = new Button("1");
        one.setOnAction(e-> on_Number_Click("1"));
        Button two = new Button("2");
        two.setOnAction(e-> on_Number_Click("2"));
        Button three = new Button("3");
        three.setOnAction(e-> on_Number_Click("3"));
        Button plus = new Button("+");
        plus.setOnAction(e-> onOperatorClick("+"));
        plus.setStyle("-fx-background-color: #FF7586");

        Button squareRoot = new Button("√");
        squareRoot.setOnAction(e-> onspecial_case("√"));
        squareRoot.setStyle("-fx-background-color: #FF7586");

        Button cube = new Button("X³");
        cube.setOnAction(e-> onspecial_case("X³"));
        cube.setStyle("-fx-background-color: #FF7586");



        Button zero = new Button("0");
        zero.setOnAction(e-> on_Number_Click("0"));
        Button point = new Button(".");
        point.setOnAction(e-> on_Number_Click("."));
        Button divide = new Button("÷");
        divide.setOnAction(e-> onOperatorClick("÷"));
        divide.setStyle("-fx-background-color: #FF7586");

        Button cubeRoot = new Button("∛");
        cubeRoot.setOnAction(e-> onspecial_case("∛"));

        cubeRoot.setStyle("-fx-background-color: #FF7586");

        Button toTheNPower = new Button("Xⁿ");
        toTheNPower.setOnAction(e-> onspecial_case("Xⁿ"));
        toTheNPower.setStyle("-fx-background-color: #FF7586");



        Button equals = new Button("=");
        equals.setOnAction(e -> equalPress("="));
        equals.setStyle("-fx-background-color: #FF7586");



        /**adds buttons to the grid**/

        grid.add(seven, 0, 2);

        grid.add(eight, 1, 2);

        grid.add(nine, 2, 2);

        grid.add(multiply, 3, 2);

        grid.add(percent, 4, 2);

        grid.add(clear, 5, 2);



        grid.add(four, 0, 3);

        grid.add(five, 1, 3);

        grid.add(six, 2, 3);

        grid.add(minus, 3, 3);

        grid.add(factorial, 4, 3);

        grid.add(squared, 5, 3);



        grid.add(one, 0, 4);

        grid.add(two, 1, 4);

        grid.add(three, 2, 4);

        grid.add(plus, 3, 4);

        grid.add(squareRoot, 4, 4);

        grid.add(cube, 5, 4);



        grid.add(zero, 0, 5);

        GridPane.setColumnSpan(zero, 2);

        zero.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);



        grid.add(point, 2, 5);

        grid.add(divide, 3, 5);

        grid.add(cubeRoot, 4, 5);

        grid.add(toTheNPower, 5, 5);



        grid.add(equals, 0, 6);

        GridPane.setColumnSpan(equals, 6);

        equals.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);





    }

    public void spaceElementsOnCalculator(){

        /**spaces out buttons*/

        grid.setHgap(20);

        grid.setVgap(20);

        grid.setPadding(new Insets(10.0));



        RowConstraints rowConstraints = new RowConstraints();

        ColumnConstraints columnConstraints = new ColumnConstraints();



        for (int i = 0; i < grid.getRowCount(); i++){





            rowConstraints.setFillHeight(true);

            rowConstraints.setVgrow(Priority.ALWAYS);

            grid.getRowConstraints().add(rowConstraints);

        }

        for (int i = 0; i < grid.getColumnCount(); i++){

            columnConstraints.setFillWidth(true);

            columnConstraints.setHgrow(Priority.ALWAYS);



            grid.getColumnConstraints().add(columnConstraints);

        }



        /**makes buttons the same size*/

        for (int i = 0; i < grid.getChildren().size(); i++){

            Node element = grid.getChildren().get(i);

            if (element instanceof Button){

                Button button = (Button) grid.getChildren().get(i);

                String buttonStyle = button.getStyle();

                button.prefWidthProperty().bind(grid.widthProperty().divide(6));

                button.prefHeightProperty().bind(grid.heightProperty().divide(7));

                //ugly border                button.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

                button.setOnMouseEntered(e -> {

                    button.setStyle("-fx-background-color: #D9D9D9;");



                });

                button.setOnMouseExited(e -> {



                    button.setStyle(buttonStyle);



                });

            } else if (element instanceof Label) {

                Label result = (Label) grid.getChildren().get(i);

                result.prefWidthProperty().bind(grid.widthProperty().divide(6));

                result.prefHeightProperty().bind(grid.heightProperty().divide(7));

            } else if (element instanceof TextField) {

                TextField result = (TextField) grid.getChildren().get(i);

                result.prefWidthProperty().bind(grid.widthProperty().divide(6));

                result.prefHeightProperty().bind(grid.heightProperty().divide(7));



            }



        }


        


    }
    public void on_Number_Click(String number)//number click append to String
    {
        container1+=number;         //this not gona be reset 
        container2+=number;         //this will be reset 
        update();
        check_oper=false;
        

    }
    /////////////////////////////////
    public void onOperatorClick(String op)
    {
        //System.out.println(input.getText()+"this is the length");
        if(check_oper==false)
        {
            check_oper=true;
            //screen_shot=container1+op;
            operation.add(op);//this keep track of the operation counter in a list
             //System.out.println(op);
            //System.out.println(tracker.size());
            if(operation.size()==2)      //1 are a starting index number
               { 
                equalPress("multiple operation:"+op);
                //container1+=op;
                //container1+=op.replaceAll("[XY]","");
                }
            else
            {
                tracker.add(container2);            //a list that contain add the number and operation
               // System.out.println(container2+"sam");
               
               //System.out.println(screen_shot+" this is the index 0");
               if(tracker.get(0)=="" && op.equals("-") )//this for negative leading case -6 or -6+5
               {
                //negative=true;
                //System.out.println("it go in");
                tracker.set(0, "0");
                //tracker.add(2,"-");
               }
               container1+=op.replaceAll("[XY]","");
                if((tracker.get(0).equals("√") && op.equals("-"))||(tracker.get(0).equals("∛") && op.equals("-")))
                {
                    Throw_warning(tracker.get(0)+op+" This is a invalid operation ! please close the popup and hit the clear button or the backspace key !");
                    result.setText("please hit the clear button or the backspace key !");
                    onclear("clearing the memory");
                    
                }
               /*else if(tracker.get(0)=="")
               {screen_shot=input.getText().substring(0,input.getText().indexOf(op)-1);///this is keybroard 
                keybroard(screen_shot);
                container1+=screen_shot;
               }*/
                
                
                tracker.add(op);
                container2=""; 
                
                update();
            }
           
            
            //System.out.println(op +"this is operation");
                      //reset the container
            
        } 
       
        else if(operation.size()>=1)        //for negative second number 
            { if(op.equals("-"))
               { 
               // System.out.println(op.equals("-")+"check sample this ");
                container2+=op;
                container1+=op;
                }
            }
    }
    ////////////////////////////////////////////////////////////////////
    public void onspecial_case(String op)
    {
        
                container2+=op;
               
                container1+=op.replaceAll("[XY]","");
                update();
    }
    ////////////////////////////////////////////////////////////////////
    public void onclear(String op)
    {
        container1="";
        check_oper=false;
        tracker.clear();
        operation.clear();
        container2="";
        update();
    }
    ///////////////////////////////////////////////////////////////
    public void update()
    {
        input.setText(container1);
    }
    ////////////////////////////////////////////////////////////////
    public void equalPress(String oper)
    {
        String[] receive=new String[4];
        boolean floating_point=false;
        //System.out.println(oper+"before");
        if(oper.contains("multiple operation:"))
        {//do stuffand return back 
                
                //oper=oper.replaceAll("multiple operation:","");
                //System.out.println(oper+"check");
               // keybroard();
                operation.remove(0);
                //System.out.println(container2+" peak container2");
                tracker.add(container2);
                receive=separate();     ///this will replace sample String
                //System.out.println(tracker.size()+"check size ");
                if(receive[3].equals("2")|| receive[3].equals("1")||receive[3].equals("12"))
                { floating_point=true;

                }
                String prev_sum=number_format(logic_call(receive[0], receive[1], receive[2], receive[3], floating_point));
                //logic_call(receive[0],receive[1],receive[3])
                tracker.add(prev_sum);
                tracker.add(operation.get(0));
               
                //System.out.println(tracker.get(0)+tracker.get(1)+"this is the out of two operation ");
                container1=tracker.get(0)+tracker.get(1);    
                //container1+=tracker.get(1);

        }
        else
        {
            //keybroard();
            tracker.add(container2);
            if (tracker.size()>=2)
            {
                if((tracker.get(2).contains("√-"))||(tracker.get(2).contains("∛-")))
                {
                    Throw_warning(tracker.get(2)+" This is a invalid operation ! please close the popup and hit the clear button or the backspace key !");
                    result.setText("please hit the clear button or the backspace key !");
                    onclear("clearing the memory");
                    //System.out.println();
                }
            }
            //for(String i:tracker)
                //System.out.println(i+"please check this");
            receive=separate();}
            if(receive[1].contains("illegal value!"))//warning message //this was never implemented and right now it just a placeholder.  
                    {
                        result.setText("this value are illegal: "+receive[0]);
                    }
            else if(receive[3].equals("2")|| receive[3].equals("1")||receive[3].equals("12"))
            {
                floating_point=true;
                String extract=logic_call(receive[0], receive[1], receive[2], receive[3], floating_point);
                extract=number_format(extract);
                //System.out.println(extract.length()+ " this is the length1");
                if((extract.length())+(memory.get(memory.size()-1).length())>10)
                {//checking see if extract respond 
                    result.setText(memory.get(memory.size()-1)+"="+extract);
                    popup(extract);
                    //onclear("clear");

                }
                else
                {
                    //result.setText(memory.get(memory.size()-1)+"="+number_format(extract));//extract 
                    result.setText(memory.get(memory.size()-1)+"="+extract);
                    //onclear("clear");
                }
            }  
            else//boths numbers are integer 
            {
            
                String extract=logic_call(receive[0], receive[1], receive[2], receive[3], floating_point);
                //System.out.println(extract+"this is test");
                extract=number_format(extract);
               // System.out.println(extract.length()+ " this is the length");
                if((extract.length())+(memory.get(memory.size()-1).length())>10)
                {   //checking see if extract respond 
                    popup(extract);
                    result.setText(memory.get(memory.size()-1)+"="+extract);          //max number can be display are 15 characters spaces 
                }
                else
                {
                    result.setText(memory.get(memory.size()-1)+"="+extract);
                }
            }

    }
    //////////////////////////////////////////////////////////////////////////
    private  String[] separate()
    {
        String[] packet=new String[4];
        String first_number="";
        String final_number="";
        String operation="";
        int counter=0;
        String ret="";
        boolean flag=false;
        boolean first_missing_0=false;
        String float_number="false";
        String float_num="";
        String mem="";
        String conver="";
        for (String i:tracker)
        {
          // System.out.println(i.matches("[0-9]$")+"this");///problem 
           //System.out.println(i);
           //System.out.println(i.contains("."));
            mem+=i;
            if(i.contains("³")||i.contains("√")||i.contains("∛")||i.contains("!")||i.contains("²")||i.contains("ⁿ"))
               {
                /*if(!(i.matches("[0-9]+")))
                {//warning packet
                    
                    System.out.print("this has being the root negative ");
                    packet[0]=i;
                    packet[1]="illegal value!";
                    return packet;
                }*/
                //mem+=i;
                //System.out.println("this has go in"+i);
                 ret=special_op(i);
                 flag=true;
                }
                
            if(i.contains("."))
                {
                    float_number="true";
                   // System.out.println("this the index check"+i.indexOf("."));
                    if( i.indexOf(".")==0)          ///this will run if there are missing number in front of a decimal. 
                    {
                        first_missing_0=true;
                        conver=number_format(i);
        
                    }
                }
            if(counter==0)
            {
                if(float_number.equals("false"))//first number 
                {
                    if(flag==true)//this will trigger if there a special operation averable 
                        {
                            if(first_missing_0==true)            //this will check for the missing number of [0].00021
                            {
                                first_number=conver;
                                counter+=1;
                                first_missing_0=false;
                                flag=false;
                            }
                            else
                            {
                                //System.out.println(float_number+"31321");
                                first_number=ret;
                                //System.out.println(first_number+ "this is check");
                                counter+=1;
                                flag=false;
                            }
                        }
                    else
                    {
                        if(first_missing_0==true)            //this will check for the missing number of [0].00021
                            {
                                first_number=conver;
                                counter+=1;
                                first_missing_0=false;
                                flag=false;
                            }
                        else
                        {
                            first_number=i;
                            counter+=1;
                            flag=false;
                        }
                        
                    }
                }//end of checking input for floating number placement 
                else        //beginning of non float input operation 
                {
                    if(flag==true)
                    {
                        if(first_missing_0==true)            //this will check for the missing number of [0].00021
                            {
                                first_number=conver;
                                counter+=1;
                                first_missing_0=false;
                                flag=false;
                            }
                            else
                            {
                              //  System.out.println("int");
                                first_number=ret;                   //not ret is the value of the special operation when call 
                                counter+=1;
                               // System.out.println(counter+"the counter");
                                float_num+="1";
                              //  System.out.println("go in");
                                float_number="false";
                              //  System.out.println(float_num);
                                flag=false;

                            }
                        
                    }
                    else                //this is a normal oberation checker container 
                    {

                        if(first_missing_0==true)            //this will check for the missing number of [0].00021
                            {
                                first_number=conver;
                                counter+=1;
                                first_missing_0=false;
                                flag=false;
                            }
                            else
                            {
                           // System.out.println("int");
                            first_number=i;
                            counter+=1;
                           // System.out.println(counter+"the counter");
                            float_num+="1";
                           // System.out.println("go in");
                            float_number="false";
                            //System.out.println(float_num);
                            flag=false;
                            }
                        
                    }
                    
                }
                
            }/////////end of the first container value

            else if(counter==1)     //the container of the operation 
            {
                operation=i;
                counter+=1;
            }
            else
            { 
                if (i=="")//this will responsible 
                 {   final_number="null";}
                else if(float_number.equals("false"))
                {
                    if(flag==true)
                    {
                        if(first_missing_0==true)            //this will check for the missing number of [0].00021
                            {
                                final_number=conver;    
                                counter+=1;
                                first_missing_0=false;
                                flag=false;
                            }
                            else
                            {
                                final_number=ret;
                                counter+=1;
                                flag=false;
                            }
                        
                    }
                    else
                    {
                        if(first_missing_0==true)            //this will check for the missing number of [0].00021
                            {
                                final_number=conver;    
                                counter+=1;
                                first_missing_0=false;
                                flag=false;
                            }
                        else
                        {
                            final_number=i;
                            counter+=1;
                            flag=false;
                        }
                        
                    }
                    
                }
                else
                {
                    if(flag==true)
                    {
                        if(first_missing_0==true)            //this will check for the missing number of [0].00021
                            {
                                final_number=conver;    
                                counter+=1;
                                first_missing_0=false;
                                flag=false;
                            }
                        else
                        {
                            final_number=ret;
                            counter+=1;
                            float_num+="2";
                            flag=false;
                        }
                        
                    }
                    else            ///normal number and not float value container.
                    {
                        if(first_missing_0==true)            //this will check for the missing number of [0].00021
                            {
                                final_number=conver;    
                                counter+=1;
                                first_missing_0=false;
                                flag=false;
                            }
                        else
                        {
                            final_number=i;
                            counter+=1;
                            float_num+="2";
                            flag=false;
                        }
                        
                    }
                    
                }
                
            }
           
        }
        System.out.println(first_number+" : this is the first number ");
        System.out.println(final_number+" : this is the second number ");
        System.out.println(operation+" : this is the operation ");
        System.out.println(float_number+" : is this a float ? ");///dont need */
        System.out.println(float_num+" :what are the float value:1=number 1, 2=number2, 12=both");  //determin which one is float 
        for(int i=0; i < packet.length; i++)
        {
            //System.out.println(i);
            if(i==0)                 //case0 contain first number
                 packet[i]=first_number;
            else if(i==1)           //case1 contain the second number
                packet[i]=final_number;
            else if(i==2)                    //case 3 contain the operation
                packet[i]=operation;
            else                //case 4 contain the flag of float or not 
                packet[i]=float_num;
                //case 5:                 //case 5 contain the totals numbers are in float
                //packet[i]=float_num;

            
           
        }
        //for(String i: packet)
        //System.out.println(i);
        ///conver packet to memory 
        memory.add(mem);
        tracker.clear();
        container2="";
        return packet;
    }
    ///////////////////////////////////////////////////
    private String number_format(String value)
    {
        int locate=value.indexOf(".");
        if(value.indexOf(".")==0)  //.00001 ->0.00001 missing leading zero
        {
            String Return_packet="0"+value;
           // System.out.println("this is the return of 0 added to missing decimal");
            return Return_packet;

        }
        if(value.contains("."))
            {
                //System.out.println((value.length()-1)+":"+locate);
                if(value.length()-3<=locate && locate!=0)//123.00 or 245.30 or 123.00 if 
                {   //System.out.println("check this value length");
                    if(value.length()-1==locate)//123.0 or 5.0
                    {
                        //System.out.print("this is the location"+ locate);
                        //System.out.println("this is the length of perdiction "+(value.length()-1));
                        value=value+"0";
                    }
                    //zero injection
                    else
                    {   
                        //System.out.println("zero injection");
                        value=value+"00";
                    } 
                    
                }
                String last_two_num_check=value.substring(locate+1, locate+3);
               // System.out.println(last_two_num_check+"this is the last two valid numbers ");
                if(last_two_num_check.equals("00"))//remove the decimal 
                {

                    String Return_packet=value.substring(0,locate);
                   // System.out.println(Return_packet+"this is the return formated number");
                    return Return_packet;
                }
                else // if number are not .00 return normal float// or make no change and return the value
                {
                   // System.out.println("this is a return where everything is fine");
                    value=value.replaceAll("[0]+$","").replaceAll("(\\.)(?!.*?[1-9]+)","");
                    return value; 
                }
            }
        else
        {
            //value=value.replaceAll("[0]+$","");
           // System.out.println(value+"check value");
            return value;
        }
    }
    /////////////////////////////////////////////////
    private void keyboard()
    {   
        input.setOnKeyPressed(e -> {
            //if (e.getKeyLocation() == KeyEvent.VK_NUMPAD2)
                //System.out.println(e.getCode().toString());
               //System.out.println("Numpad pressed!");
               //System.out.println(e.getKeyLocation());
            switch (e.getCode().toString()){

                //old verstion of jdk can use this: ver <17
                case "DIGIT0":
                {
                    //System.out.println("test key fire !"+e.getCode().toString());
                    on_Number_Click("0");
                    break;
                }
                case "DIGIT1":
                {
                    //System.out.println("test key fire !"+e.getCode().toString());
                    on_Number_Click("1");
                    break;
                }
                case "DIGIT2":
                {
                    //System.out.println("test key fire !"+e.getCode().toString());
                    on_Number_Click("2");
                    break;
                }
                case "DIGIT3":
                {
                    //System.out.println("test key fire !"+e.getCode().toString());
                    on_Number_Click("3");
                    break;
                }
                case "DIGIT4":
                {
                    
                    on_Number_Click("4");
                    break;
                }
                case "DIGIT5":
                {
                    
                    on_Number_Click("5");
                    break;
                }
                case "DIGIT6":
                {
                    
                    on_Number_Click("6");
                    break;
                }
                case "DIGIT7":
                {
                    
                    on_Number_Click("7");
                    break;
                }
                case "DIGIT8":
                {
                    
                    on_Number_Click("8");
                    break;
                }
                case "DIGIT9":
                {
                    
                    on_Number_Click("9");
                    break;
                }
                case "NUMPAD0":
                {
                    on_Number_Click("0");
                    break;
                }
                case "NUMPAD1":
                {
                    on_Number_Click("1");
                    break;
                }
                case "NUMPAD2":
                {
                    on_Number_Click("2");
                    break;
                }
                case "NUMPAD3":
                {
                    on_Number_Click("3");
                    break;
                }
                case "NUMPAD4":
                {
                    on_Number_Click("4");
                    break;
                }
                case "NUMPAD5":
                {
                    on_Number_Click("5");
                    break;
                }
                case "NUMPAD6":
                {
                    on_Number_Click("6");
                    break;
                }
                case "NUMPAD7":
                {
                    on_Number_Click("7");
                    break;
                }
                case "NUMPAD8":
                {
                    on_Number_Click("8");
                    break;
                }
                case "NUMPAD9":
                {
                    on_Number_Click("9");
                    break;
                }////////////////operation side////////////////////
                case"DECIMAL":
                {
                    on_Number_Click(".");
                    break;
                }
                case "BACK_SPACE":
                {
                    onclear("clean");
                    break;
                }
                case "PERIOD":
                {
                    on_Number_Click(".");
                    break;
                }
                case"EQUALS":
                {
                    equalPress("=");
                    break;
                }
                case"ENTER":
                {
                    equalPress("=");
                    break;
                }
                case"ADD":
                {
                    onOperatorClick("+");
                    break;
                }
                case"SUBTRACT":
                {
                    onOperatorClick("-");
                    break;
                }
                case"MULTIPLY":
                {
                    onOperatorClick("x");
                    break;
                }
                case"DIVIDE":
                {
                    onOperatorClick("÷");
                    break;
                }
                
                
                //new version 17 or above  and remember to change the switch(e.getCode().toString()) -> switch (e.getCode())
                /*case DIGIT0 ->on_Number_Click("0");
                case DIGIT1 -> on_Number_Click("1");
                case DIGIT2 -> on_Number_Click("2");
                case DIGIT3 ->on_Number_Click("3");
                case DIGIT4 -> on_Number_Click("4");
                case DIGIT5 -> on_Number_Click("5");
                case DIGIT6 -> on_Number_Click("6");
                case DIGIT7 -> on_Number_Click("7");
                case DIGIT8 -> on_Number_Click("8");
                case DIGIT9 -> on_Number_Click("9");
                case PERIOD -> on_number_click(".");
                /////////////////////////////////////////numpad section /////////////////////////
                case NUMPAD0 ->on_Number_Click("0");
                case NUMPAD1 ->on_Number_Click("1");
                case NUMPAD2 ->on_Number_Click("2");
                case NUMPAD3 ->on_Number_Click("3");
                case NUMPAD4 ->on_Number_Click("4");
                case NUMPAD5 ->on_Number_Click("5");
                case NUMPAD6 ->on_Number_Click("6");
                case NUMPAD7 ->on_Number_Click("7");
                case NUMPAD8 ->on_Number_Click("8");
                case NUMPAD9 ->on_Number_Click("9");
                case DECIMAL >on_Number_Click(".");*/
                /////////////////////////////////////operation/////////////////
               //case ADD ->onOperatorClick("+");
               //case MULTIPLY ->onOperatorClick("x");
               //case SUBTRACT ->onOperatorClick("-");
               //case DIVIDE ->onOperatorClick("÷");
               //case ENTER ->equalPress("=");



            }
        });
        
       
    }
    private BigDecimal cuberoot_int(BigDecimal value)
    {
        /*HashMap<Integer, Integer> perfect_root=new HashMap<Integer,Integer>()
        {{
            put(1,1);
            put(2, 8);
            put(3, 27);
            put(4, 64);
            put(5, 125);
            put(6, 216);
            put(7, 343);
            put(8, 512);
            put(9, 729);
            put(10, 100);

        }};*/
        ArrayList<Integer> perfect_root= new ArrayList<>(Arrays.asList(1, 8,27,64,125,216,343,512,729,100));
        ArrayList<Integer> Last_num= new ArrayList<>(Arrays.asList(1,8,7,4,5,6,3,2,9,0));
        BigInteger conver=value.toBigInteger();
        char[] track=(conver.toString()).toCharArray();     //this contain the number 
        String back_num="";
        String font_num="";
        Integer prev=0;
        //int next=0;
        for(int i=track.length-1; i >track.length-4;i--)
        {
           // System.out.println(track[i]+"check this out");
            Integer extract_last=Last_num.indexOf(Integer.valueOf(track[i]))+1;
            back_num=extract_last.toString();
            break;
        }
        for(int i=0; i<((int)track.length/2);i++)
        {
            //System.out.println("this is first num "+ track[i]);
             font_num+=track[i];
        }
        //System.out.println();
        //////last number index get, font number next//////
        for(Integer i : perfect_root)
        {
            if(i<(Integer.valueOf(font_num)))           ///keep the number that smaller than font_num and if it bigger then exit
            {
                prev=i;
            }
            else 
            {
                break;
            }
        }
        ///////////////////////return//////////////////
        Integer font_value_index=perfect_root.indexOf(prev);
        String combine=font_value_index.toString()+back_num;
        BigDecimal return_pack=new BigDecimal(combine);
        return return_pack;
    }
    private BigDecimal cuberoot_base(BigDecimal value)
    {
        String sample=value.toString();
        char [] separate=sample.toCharArray();
        ArrayList<Integer> value_contain=new ArrayList<>();
        String base="1";
        Integer top_level=1;
        for (char i:separate)
            if(i=='.')
            {
                continue;
            }
            else
            {   
                Integer conver=Integer.valueOf(i);
                value_contain.add(conver);
            }
            Integer loop_base=value_contain.size()-1;
         for (int i=0;i<loop_base;i++)
         {
            base+="0";
         }
         BigDecimal repack=new BigDecimal(Integer.valueOf(base));
         return repack;
        /*String sample=value.toString();
        char [] separate=sample.toCharArray();
        ArrayList<Integer> value_contain=new ArrayList<>();
        String base="1";
        Integer top_level=1;
        int track=1;
        //Character compare='.';
        for (char i:separate)
            if(i=='.')
            {
                continue;
            }
            else
            {   
                Integer conver=Integer.valueOf(i);
                value_contain.add(conver);
            }
        /////////////////////////number should be separated and the decimal should be remove/////////
         Integer loop_base=value_contain.size()-1;
         for (int i=0;i<loop_base;i++)
         {
            base+="0";
         }
         /////////////////////base set/////////////////
         for(Integer i:value_contain)
         {
             top_level*=i;
         }
         top_level*=3;
         for(int i=value_contain.size()-1; i<=0;i--)
         {
            Integer extract=value_contain.indexOf(i);
            if(i+1==value_contain.size())
                extract*=extract*extract;           //^3
                track=extract;
         }*/

    }
    /////////////////////////////////////////////////////////////
    private String special_op(String input)
    {   String result;
        //boolean doubl=false;
        BigDecimal get_val;
        //Integer get_val2;
        BigDecimal get_val3;
        String operation=input.replaceAll("[0-9.]", "");
        String value=input.replaceAll("[X³√∛X!X²Xⁿ-]", "");
        //System.out.println(value+"this is value" );
        //System.out.println(operation+"this is operation");
        //System.err.println(input);
        if(value.contains("."))
        {
            BigDecimal val=new BigDecimal(value);
            switch (operation) {
                case "³":
                 {   
                     //get_val=(float) Math.pow(val, 3);
                     //BigDecimal base=val;
                     get_val=val.pow(3);
                    result=get_val.toString();
                    break;
                 }
                 case "X³":
                 {   
                     //get_val=(float) Math.pow(val, 3);
                     //BigDecimal base=val;
                     get_val=val.pow(3);
                    result=get_val.toString();
                    break;
                 }
                case"√":
                  {
                    //get_val=(float)Math.sqrt(val);
                    MathContext mathcont=new MathContext(2);
                    get_val=val.sqrt(mathcont);
                    result=get_val.toString();
                    break;
                }  
                case"∛":
                {   //get_val=(float)Math.cbrt(val);
                    //BigInteger conver=BigInteger.valueOf(Math.round(val.floatValue()));
                    //get_val=val.cbrt(1/3);
                    boolean check=val.toString().contains(".");
                    if(check)
                    {
                        /*String value_string=val.toString().replace(".","");
                        get_val=new BigDecimal(value_string);        //conver to BigDecimal with . remove 
                        BigDecimal extract=cuberoot_base(get_val).pow(3);
                        System.out.println(extract+ " :this is the extract");
                        System.out.println(get_val +"this is the value with . remove");
                        get_val=get_val.pow(3);                     //raise to the power 3
                        get_val=get_val.divide(extract);                //divide the base
                        System.out.println("this is the value"+get_val);
                        result=get_val.toString();*/
                        Float a=Float.valueOf(val.toString());
                        Double re=Math.cbrt(a);
                        result=re.toString();
                        break;
                    }
                    else
                    {
                        //System.out.println("go in");
                        //BigInteger contain=new BigInteger(val.toString());
                        Integer a=Integer.valueOf(val.toString());
                        Double re=Math.cbrt(a);
                        //Integer a=cuberoot_int(val);
                        result=re.toString();
                        break;
                    }
                    
                
                }
                case"!":
                {
                    int a=Math.round((Float.valueOf(val.toString())));
                    for(int i=a-1; i > 0;i--)
                    {
                        val=val.multiply(new BigDecimal(i));
                    }
                    result=val.toString();
                    break;
                }
                case"X!":
                {
                    int a=Math.round((Float.valueOf(val.toString())));
                    for(int i=a-1; i > 0;i--)
                    {
                        val=val.multiply(new BigDecimal(i));
                    }
                    result=val.toString();
                    break;
                }
                case "Xⁿ":
                {   Integer cal2=Integer.valueOf(String.valueOf(input.substring(input.indexOf(operation)+2)));
                    String val_st=String.valueOf(input.substring(0,input.indexOf(operation)));
                    BigDecimal cal1=new BigDecimal(Float.valueOf(val_st));
                    //System.out.println(value.charAt(value.length()-1)+"check this");
                    //get_val=(float)Math.pow(cal1,cal2);
                    get_val=cal1.pow(cal2);
                    result=get_val.toString();   
                    break;
                }
                case "ⁿ":
                {   Integer cal2=Integer.valueOf(String.valueOf(input.substring(input.indexOf(operation)+1,input.length())));
                    String val_st=String.valueOf(input.substring(0,input.indexOf(operation)));
                    BigDecimal cal1=new BigDecimal(Float.valueOf(val_st));
                    //System.out.println(value.charAt(value.length()-1)+"check this");
                    //get_val=(float)Math.pow(cal1,cal2);
                    get_val=cal1.pow(cal2);
                    result=get_val.toString();   
                    break;
                }
                default:
                    {
                        //get_val=(float)Math.pow(val,2);
                        get_val=val.pow(2);
                        result=get_val.toString();
                        //System.out.println("did it go here");
                        break;
                    }
            }
            return result;
        }
         else
        {   //System.out.println("this");
            BigDecimal val=new BigDecimal(value);
            switch (operation) 
               {
                case "³":
                 {   
                    //BigDecimal base=val;
                    //BigInteger power=BigInteger.valueOf(3);
                     //get_val3=BigInteger.valueOf((int)Math.pow(val, 3));
                     get_val3=val.pow(3);
                    // System.out.println(get_val3+"this is val3");
                    result=get_val3.toString();
                    break;
                 }
                 case "X³":
                 {   
                    //BigInteger base=val;
                    //BigInteger power=BigInteger.valueOf(3);
                     //get_val3=BigInteger.valueOf((int)Math.pow(val, 3));
                     get_val3=val.pow(3);
                   //  System.out.println(get_val3+"this is val3");
                    result=get_val3.toString();
                    break;
                 }
                case"√":
                  {
                    MathContext mathcont=new MathContext(2);
                    get_val3=val.sqrt(mathcont);
                    result=get_val3.toString();
                    break;
                }  
                case"∛":
                {   //get_val3=Math.pow(val,(1/3));
                    
                        //BigInteger contain=new BigInteger(val.toString());
                        Integer a=Integer.valueOf(val.toString());
                        Double re=Math.cbrt(a);
                        //Integer a=cuberoot_int(val);
                        result=re.toString();
                        break;
                    
                    
                }
                case"X!":
                {
                    int a=val.intValue();
                    for(int i=a-1; i > 0;i--)
                    {
                        val=val.multiply((BigDecimal.valueOf(i)));
                    //    System.out.println(val);
                    }
                    result=val.toString();
                    break;
                }
                case"!":
                {
                    int a=val.intValue();
                    for(int i=a-1; i > 0;i--)
                    {
                        val=val.multiply((BigDecimal.valueOf(i)));
                 //      System.out.println(val);
                    }
                    result=val.toString();
                    break;
                }
                case "Xⁿ":
                {   
                    //System.out.println(input.substring(input.indexOf(operation)+2));
                    //System.out.println(input.substring(0,input.indexOf(operation)));
                    String separ=String.valueOf(input.substring(input.indexOf(operation)+2));
                    String val_st=String.valueOf(input.substring(0,input.indexOf(operation)));
                    //System.out.println(separ+"check separ");
                    Integer cal=Integer.valueOf(separ);
                    BigDecimal cal2=new BigDecimal(val_st);
                    //System.out.println();
                    //System.out.println(cal+"check this cal"+cal2);
                    //get_val3=BigInteger.valueOf((int)Math.pow(cal2,cal));
                    get_val3=cal2.pow(cal);
                     result=get_val3.toString();
                  //  System.out.println(result+" check result");
                     
                    break; 
                }
                case "ⁿ":
                {   
                   // System.out.println(input.substring(input.indexOf(operation)+2));
                   // System.out.println(input.substring(0,input.indexOf(operation))+"beginning value");
                    String separ=String.valueOf(input.substring(input.indexOf(operation)+1,input.length()));
                    String val_st=String.valueOf(input.substring(0,input.indexOf(operation)));
                   // System.out.println(separ+"check separ");
                    Integer cal=Integer.valueOf(separ);
                    BigDecimal cal2=new BigDecimal(val_st);
                   // System.out.println();
                 //   System.out.println(cal+"check this cal"+cal2);
                    //get_val3=BigInteger.valueOf((int)Math.pow(cal2,cal));
                    get_val3=cal2.pow(cal);
                     result=get_val3.toString();
                //   System.out.println(result+" check result");
                     
                    break; 
                }
                default:
                    {
                        get_val3=val.pow(2);
                        result=get_val3.toString();
                        break;
                    }
               }
            return result;
        
        }
    }
    private void popup(String value)
    {
        String extract=memory.get(memory.size()-1)+"="+value;
        char[] scale=extract.toCharArray();
        BorderPane border = new BorderPane();
        Scene scene=new Scene(border,scale.length+200,200);
        Stage state=new Stage();
        Text text=new Text();
        text.setText(extract);
        text.setFont(new Font(20));
        //text.setX(50); 
        //text.setY(50);
        border.setTop(text);
        text.wrappingWidthProperty().bind((border.widthProperty()));
        //System.out.println(border.getHeight());
        //System.out.println(border.getWidth());
        //System.out.println(scale.length);
        state.setScene(scene);
        state.setTitle(memory.get(memory.size()-1));
        state.show();
    }
    private void Throw_warning(String value)
    {
        String extract=value;
        char[] scale=extract.toCharArray();
        BorderPane border = new BorderPane();
        Scene scene=new Scene(border,scale.length+200,200);
        Stage state=new Stage();
        Text text=new Text();
        text.setText(extract);
        text.setFont(new Font(25));
        //text.setX(50); 
        //text.setY(50);
        border.setTop(text);
        text.wrappingWidthProperty().bind((border.widthProperty()));
        //text.wrappingWidthProperty().bind(border.heightProperty());
        //System.out.println(border.getHeight());
        //System.out.println(border.getWidth());
        //System.out.println(scale.length);
        state.setScene(scene);
        state.setTitle("Error Warning !");
        state.show();
    }

    public String logic_call(String num1,String num2,String oper,String float_check,boolean flag)
    {
        String total="";
        BigDecimal Number1;
        BigDecimal Number2;
        //BigInteger conver_b;
        //BigInteger conver_a;
        //System.out.println(oper+"this is operation check");
        //System.out.println(flag+"this is a flag");
        if(oper!="")    //if there exist a operation 
        {
            if(flag==true)
            {
                switch (float_check) {
                    case "1":
                    {    
                        //System.out.println("first number are float");
                        //Number1=Float.parseFloat(num1) ;
                        Number1=new BigDecimal(num1);
                        switch (oper) {
                            case "+":
                                    {  
                                        Number1=(Number1.add(new BigDecimal(num2).setScale(2, RoundingMode.HALF_EVEN)));

                                        total=Number1.toString();
                                        break;
                                    }
                            
                                case"-":
                                {     Number1=(Number1.subtract(new BigDecimal(num2).setScale(2, RoundingMode.HALF_EVEN)));

                                        total=Number1.toString();
                                    
                                        break;
                                }    
                                case"÷":
                                    { 
                                    Number1=(Number1.divide(new BigDecimal(num2).setScale(2, RoundingMode.UNNECESSARY)));
                                        total=Number1.toString();
                                    
                                        break;
                                } 
                                case"%":
                                    {
                                        System.out.println(Number1+"this is number 1");
                                        Number1=(Number1.remainder(new BigDecimal(num2).setScale(2, RoundingMode.HALF_EVEN)));
                                        System.out.println(Number1+"this is the return ");
                                        total=Number1.toString();
                                        break;
                                    }
                                case"x":
                                {   Number1=((Number1.multiply(new BigDecimal(num2).setScale(2, RoundingMode.HALF_EVEN))));
                                        total=Number1.toString();
                                    
                                        break;
                                    }
                        }
                        break;
                        
                    }
                    case "2":
                    { //System.out.println("second number are float");
                    //Number1=Float.parseFloat(num1) ;
                    Number1=new BigDecimal(Float.parseFloat(num1));
                    switch (oper)
                        {
                        case "+":
                                {  
                                    Number1=(Number1.add(new BigDecimal(Float.parseFloat(num2)).setScale(2, RoundingMode.HALF_EVEN)));

                                    total=Number1.toString();
                                    break;
                                }
                        
                            case"-":
                            {     Number1=(Number1.subtract(new BigDecimal(Float.parseFloat(num2)).setScale(2, RoundingMode.HALF_EVEN)));

                                    total=Number1.toString();
                                
                                    break;
                            }    
                            case"÷":
                                { 
                                Number1=(Number1.divide(new BigDecimal(Float.parseFloat(num2)).setScale(2, RoundingMode.UNNECESSARY)));
                                    total=Number1.toString();
                                
                                    break;
                            } 
                            case"%":
                                {
                                 //   System.out.println(Number1+"this is case 2");
                                    Number1=(Number1.remainder(new BigDecimal(Float.parseFloat(num2)).setScale(2, RoundingMode.HALF_EVEN)));
                               //     System.out.println(Number1+"this is the return ");
                                    total=Number1.toString();
                                    break;
                                }
                            case"x":
                            {   Number1=(Number1.multiply(new BigDecimal(Float.parseFloat(num2)).setScale(2, RoundingMode.HALF_EVEN)));
                                    total=Number1.toString();
                                
                                    break;
                                }
                        }
                        break;
                    }
                        
                    case "12":
                        //System.out.println("both number are float");
                        //Number1=Float.parseFloat(num1);
                       // Number2=Float.parseFloat(num2);
                         Number1=new BigDecimal((Float.parseFloat(num1)));
                         Number2=new BigDecimal(Float.parseFloat(num2));
                         switch (oper) {
                            case "+":
                                    {  
                                        Number1=Number1.add(Number2.setScale(2, RoundingMode.HALF_EVEN));

                                        total=Number1.toString();
                                        break;
                                    }
                            
                                case"-":
                                {     Number1=Number1.subtract(Number2.setScale(2, RoundingMode.HALF_EVEN));

                                        total=Number1.toString();
                                    
                                        break;
                                }    
                                case"÷":
                                    { 
                                    Number1=Number1.divide(Number2.setScale(2, RoundingMode.UNNECESSARY));
                                        total=Number1.toString();
                                    
                                        break;
                                } 
                                case"%":
                                    {
                                       // System.out.println(Number1+"this is number 12");
                                        Number1=(Number1.remainder(Number2.setScale(2, RoundingMode.HALF_EVEN)));
                                        //System.out.println(Number1+"this is the return ");
                                        total=Number1.toString();
                                        break;
                                    }
                                case"x":
                                {   Number1=Number1.multiply(Number2.setScale(2, RoundingMode.HALF_EVEN));
                                        total=Number1.toString();
                                    
                                        break;
                                }
                        }
                }
                //run some code after break
                return total;
            }
            else 
            {   //no need to change string to float
              //  System.out.println("there are no floating number in session ");
                        Number1=new BigDecimal((Float.parseFloat(num1)));
                        Number2=new BigDecimal(Float.parseFloat(num2));
            switch (oper) {
                    case "+":
                        {   /*conver_a=new BigInteger(num1);
                            conver_b=new BigInteger(num2);*/
                            Number1=Number1.add(Number2.setScale(2, RoundingMode.HALF_EVEN));
                            total=Number1.toString();
                            break;
                        }
                
                    case"-":
                    {      // conver_a=new BigInteger(num1);
                            //conver_b=new BigInteger(num2);
                            Number1=Number1.subtract(Number2.setScale(2, RoundingMode.HALF_EVEN));
                            total=Number1.toString();
                       //     System.out.println(Number2+"this is number 2");
                            break;
                    }    
                    case"÷":
                    {      // conver_a=new BigInteger(num1);
                            //conver_b=new BigInteger(num2);
                            Number1=Number1.divide(Number2.setScale(2, RoundingMode.UNNECESSARY));
                            //System.out.println("did it go in here");
                            total=Number1.toString();
                            break;
                    } 
                    case"%":
                    {   //conver_a=new BigInteger(num1);
                        //conver_b=new BigInteger(num2);
                        //System.out.println(Number1+"this is number 1");
                        Number1=Number1.remainder(Number2.setScale(2, RoundingMode.HALF_EVEN));
                        //System.out.println(Number1+"this is the return ");
                        //Number1=(Number1%(Float.valueOf(num2)));
                        total=Number1.toString();
                        break;
                    }
                    case"x":
                    {       //conver_a=new BigInteger(num1);
                            //conver_b=new BigInteger(num2);
                            Number1=Number1.multiply(Number2.setScale(2, RoundingMode.HALF_EVEN));
                            total=Number1.toString();
                            break;
                        }
            
                }
                
            }
            return total;
        } 
    
    else
    {
       // System.out.println("this should run");
        return total=num1;
    }

}
}

