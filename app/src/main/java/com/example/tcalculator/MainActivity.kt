package com.example.tcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.example.tcalculator.Operator
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import kotlin.math.abs

class MainActivity : AppCompatActivity() {

    var result:Double=0.0
    var temp_result:Double=0.0
    var flag_equal:Boolean=false
    var flag_op:Int =0
    var flag_point_repeat:Int=0
    var Express:String=""
    var temp_Express:String="0"
    var temp_op:Int=0
    var flag_detect_op:Int=0
    var flag_on_off:Boolean=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      //object definition
        val dispaly_disp=findViewById<TextView>(R.id.cal_disp)
        val clear_bn=findViewById<Button>(R.id.clear)
        val pluls_bn=findViewById<Button>(R.id.plus)
        val minus_bn=findViewById<Button>(R.id.minus)
        val muti_bn=findViewById<Button>(R.id.muti)
        val divide_bn=findViewById<Button>(R.id.divide)
        val total_bn=findViewById<Button>(R.id.result)
        val num0_bn=findViewById<Button>(R.id.number0)
        val num1_bn=findViewById<Button>(R.id.number1)
        val num2_bn=findViewById<Button>(R.id.number2)
        val num3_bn=findViewById<Button>(R.id.number3)
        val num4_bn=findViewById<Button>(R.id.number4)
        val num5_bn=findViewById<Button>(R.id.number5)
        val num6_bn=findViewById<Button>(R.id.number6)
        val num7_bn=findViewById<Button>(R.id.number7)
        val num8_bn=findViewById<Button>(R.id.number8)
        val num9_bn=findViewById<Button>(R.id.number9)
        val backspace_bn=findViewById<Button>(R.id.backspace)
        val on_off_bn=findViewById<Button>(R.id.on_off)
        val point_bn=findViewById<Button>(R.id.point)
        val sign_bn=findViewById<Button>(R.id.sign)

        fun intiizalize_oper()
        {
            flag_op=0
            flag_point_repeat=0
            temp_Express=Express
            temp_op=flag_detect_op
            Express="0"
        }
        fun initizalize_cal()
        {
             result=0.0
             temp_result=0.0
             flag_equal=false
             flag_op=0
             flag_point_repeat=0
             Express="0"
             temp_Express="0"
             temp_op=0
             flag_detect_op=0
        }
        fun on_off()
        {
            dispaly_disp.isEnabled=flag_on_off
            clear_bn.isEnabled=flag_on_off
            pluls_bn.isEnabled=flag_on_off
            minus_bn.isEnabled=flag_on_off
            muti_bn.isEnabled=flag_on_off
            divide_bn.isEnabled=flag_on_off
            total_bn.isEnabled=flag_on_off
            num0_bn.isEnabled=flag_on_off
            num1_bn.isEnabled=flag_on_off
            num2_bn.isEnabled=flag_on_off
            num3_bn.isEnabled=flag_on_off
            num4_bn.isEnabled=flag_on_off
            num5_bn.isEnabled=flag_on_off
            num6_bn.isEnabled=flag_on_off
            num7_bn.isEnabled=flag_on_off
            num8_bn.isEnabled=flag_on_off
            num9_bn.isEnabled=flag_on_off
            backspace_bn.isEnabled=flag_on_off
            point_bn.isEnabled=flag_on_off
            sign_bn.isEnabled=flag_on_off
        }
        on_off()
        initizalize_cal()
     //process calculation

        fun display_Fomart(expreesion:String): String {
            var temp_expreesion:String=expreesion
            var temp_number:Double=temp_expreesion.toDouble()
            if(temp_number-temp_number.toInt()==0.0)
            {
                var dis_temp:Int=temp_number.toInt()
                return dis_temp.toString()
            }
            else
            {
                return temp_number.toString()
            }
        }
        fun display(dis_result:Double)
        {
            dispaly_disp.text=display_Fomart(dis_result.toString())
        }
        fun process_cal()
        {

            when(flag_detect_op) {
                0->{
                     result=Express.toDouble()
                }
                1 -> {
                      result=result+Express.toDouble()
                      display(result)
                      }
                2 -> {
                        result=result-Express.toDouble()
                        display(result)
                     }
                3 -> {
                    Log.d("result22", result.toString())

                    var temp_1:Double=Express.toDouble()
                   // Log.d("result33", temp_1.toString())
                    result=result*temp_1

                    result=display_Fomart(String.format("%.6f", result)).toDouble()

                    Log.d("result", result.toString())
                    display(result)
                     }
                4 ->{
                    result=result/Express.toDouble()
                    display(result)
                    }
            }
            intiizalize_oper()
        }

     //on/off button
        on_off_bn.setOnClickListener{
            flag_on_off=!flag_on_off
            on_off()
            initizalize_cal()
            if (flag_on_off)
            {
                initizalize_cal()
                dispaly_disp.text="0"
                    //clear
                    clear_bn.setOnClickListener{
                        result=0.0
                        initizalize_cal()
                        dispaly_disp.text="0"
                    }
                    //+ operation

                    pluls_bn.setOnClickListener{
                        dispaly_disp.text=display_Fomart(dispaly_disp.text.toString())
                        if(flag_op==0 && flag_equal==false)
                        {
                            process_cal()
                            flag_op=1
                        }
                        flag_detect_op=1
                        flag_equal=false
                    }
                    //- operator
                    minus_bn.setOnClickListener{
                        dispaly_disp.text=display_Fomart(dispaly_disp.text.toString())
                        if(flag_op==0 && flag_equal==false)
                        {
                            process_cal()
                            flag_op=1
                        }
                        flag_detect_op=2
                        flag_equal=false
                    }
                    //* operator
                    muti_bn.setOnClickListener {
                        dispaly_disp.text=display_Fomart(dispaly_disp.text.toString())
                        if(flag_op==0 && flag_equal==false)
                        {
                            process_cal()
                            flag_op=1
                        }
                        flag_detect_op=3
                        flag_equal=false
                    }
                    // /operator
                    divide_bn.setOnClickListener{
                        dispaly_disp.text=display_Fomart(dispaly_disp.text.toString())
                        if(flag_op==0 && flag_equal==false)
                        {
                            process_cal()
                            flag_op=1
                        }
                        flag_detect_op=4
                    }
                    // =operator
                    total_bn.setOnClickListener{

                        if(flag_equal)
                        {
                            Express=temp_Express
                            flag_detect_op=temp_op
                            process_cal()
                        }
                        if(flag_op==0 && flag_equal==false)
                        {
                            flag_equal=true
                            temp_op=flag_detect_op
                            process_cal()
                            flag_op=1
                        }
                        if(flag_op==1 && flag_equal==false)
                        {
                            flag_equal=true
                            temp_op=flag_detect_op
                            Express=temp_Express
                            process_cal()
                            flag_op=1
                        }

                    }
                    //input 0
                    num0_bn.setOnClickListener{
                        flag_op=0
                        flag_equal=false
                        Express=Express+"0"
                        if(abs(Express.toDouble())>1 && flag_point_repeat==0)
                        {
                            Express=display_Fomart(Express)
                        }
                        if(Express.length>1 && Express.get(1)!='.' &&abs(Express.toDouble())<1)
                        {
                            Express=display_Fomart(Express)
                        }

                        dispaly_disp.text=Express
                    }
                    //input 1
                    num1_bn.setOnClickListener{
                        flag_op=0
                        flag_equal=false
                        if(Express=="0")
                        {
                            Express=""
                        }
                        Express=Express+"1"
                        dispaly_disp.text=Express
                    }
                    //input 2
                    num2_bn.setOnClickListener{
                        flag_op=0
                        flag_equal=false
                        if(Express=="0")
                        {
                            Express=""
                        }
                        Express=Express+"2"
                        dispaly_disp.text=Express
                    }
                    //input 3
                    num3_bn.setOnClickListener{
                        flag_op=0
                        flag_equal=false
                        if(Express=="0")
                        {
                            Express=""
                        }
                        Express=Express+"3"
                        dispaly_disp.text=Express
                    }
                    //input 4
                    num4_bn.setOnClickListener{
                        flag_op=0
                        flag_equal=false
                        if(Express=="0")
                        {
                            Express=""
                        }
                        Express=Express+"4"
                        dispaly_disp.text=Express
                    }
                    //input 5
                    num5_bn.setOnClickListener{
                        flag_op=0
                        flag_equal=false
                        if(Express=="0")
                        {
                            Express=""
                        }
                        Express=Express+"5"
                        dispaly_disp.text=Express
                    }
                    //input 6
                    num6_bn.setOnClickListener{
                        flag_op=0
                        flag_equal=false
                        if(Express=="0")
                        {
                            Express=""
                        }
                        Express=Express+"6"
                        dispaly_disp.text=Express
                    }
                    //input 7
                    num7_bn.setOnClickListener{
                        flag_op=0
                        flag_equal=false
                        if(Express=="0")
                        {
                            Express=""
                        }
                        Express=Express+"7"
                        dispaly_disp.text=Express
                    }
                    //input 8
                    num8_bn.setOnClickListener{
                        flag_op=0
                        flag_equal=false
                        if(Express=="0")
                        {
                            Express=""
                        }
                        Express=Express+"8"
                        dispaly_disp.text=Express
                    }
                    //input 9
                    num9_bn.setOnClickListener{
                        flag_op=0
                        flag_equal=false
                        if(Express=="0")
                        {
                            Express=""
                        }
                        Express=Express+"9"
                        dispaly_disp.text=Express
                    }
                    //input.
                    point_bn.setOnClickListener{
                        flag_op=0
                        flag_equal=false
                        if(flag_point_repeat==0)
                        {
                            if(Express.isNotEmpty()){
                                Express=Express+"."
                                dispaly_disp.text=Express
                            }
                            else
                            {
                                Express=Express+"0."
                            }
                            flag_point_repeat=1
                        }
                    }
                    //backspace
                    backspace_bn.setOnClickListener{
                        if(Express.isNotEmpty()&&Express.length>1){
                            Express = Express.substring(0,Express.length-1)
                            dispaly_disp.text=Express
                        }
                        if(Express.length==1)
                        {
                            Express="0"
                            dispaly_disp.text=Express
                        }

                    }
                //+/- button
                   sign_bn.setOnClickListener{
                       if(Express.isNotEmpty()&&Express.length>0)
                       {
                           if(Express.toFloat()>0)
                           {
                               Express="-"+Express;
                           }
                           else
                           {
                               Express = Express.substring(1,Express.length)
                           }
                           dispaly_disp.text=Express
                       }
                       if(result!=0.0)
                       {
                           result=-result
                           display(result)
                       }
                  }
            }
            else
            {

                dispaly_disp.text=""
            }
        }

    //calculation
    }
}
