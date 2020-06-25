package com.example.neil.rushhourpro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InputActivity extends AppCompatActivity {

    private Button myButton;
    private ImageButton mhomeButton;
    private EditText meditText;
    private ArrayList<String> mresult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        myButton = (Button)findViewById(R.id.button1);
        mhomeButton = (ImageButton)findViewById(R.id.homebutton);
        meditText = (EditText) findViewById(R.id.edittext);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String initial = meditText.getText().toString();
                mresult = BFS(initial);
                if (mresult == null) {
                    Toast.makeText(InputActivity.this, String.valueOf("Invalid puzzle."), Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent i = new Intent(InputActivity.this, SolveActivity.class);
                    i.putExtra("list", mresult);
                    startActivity(i);
                }
            }
        });
        mhomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(InputActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

    public static ArrayList<String> BFS(String init_state)
    {
        ArrayList<String> frontier = new ArrayList<String>();
        frontier.add(init_state);
        Map<String, String> explored = new HashMap<String, String>();
        while (frontier.size() != 0)
        {
            String state = frontier.remove(0);
            if (goalTest(state.substring(12, 18)))
            {
                return generate_path(state, explored);
            }
            if (state.equals(init_state))
                explored.put(state, "s");
            ArrayList<String> children = generate_children(state);
            for (String i: children)
            {
                if (!explored.containsKey(i))
                {
                    explored.put(i, state);
                    frontier.add(i);
                }
            }
        }
        return null;
    }
    public static boolean goalTest(String state)
    {
        return ((state.equals("SE....")) || (state.equals(".SE...")) || (state.equals("..SE..")) || (state.equals("...SE.")) || (state.equals("....SE")));
    }
    public static ArrayList<String> generate_path(String n, Map<String, String> explored)
    {
        ArrayList<String> l = new ArrayList<String>();
        System.out.println(n);
        System.out.println(explored.get(n));
        System.out.println(explored.get(explored.get(n)));
        while (!explored.get(n).equals("s"))
        {
            l.add(0, n);
            n = explored.get(n);
        }
        return l;
    }
    public static ArrayList<String> generate_children(String state)
    {
        ArrayList<String> children = new ArrayList<String>();
        for (int i = 0; i < state.length(); i++)
        {
            if ((state.substring(i,i+1).equals("<")) || (state.substring(i,i+1).equals("S")))
                children.add(left(i, state));
            if ((state.substring(i,i+1).equals(">")) || (state.substring(i,i+1).equals("E")))
                children.add(right(i, state));
            if (state.substring(i,i+1).equals("^"))
                children.add(up(i, state));
            if (state.substring(i,i+1).equals("v"))
                children.add(down(i, state));
        }
        return children;
    }
    public static String left(int x, String state)
    {
        if (x % 6 <= 0)
            return state;
        String s = state;
        if ((s.substring(x,x+1).equals("<")) || (s.substring(x,x+1).equals("S")))
        {
            if (s.substring(x-1,x).equals("."))
            {
                s = swap(s, x-1, x);
                x += 1;
            }
        }
        if ((s.substring(x,x+1).equals("L")))
        {
            if (s.substring(x-1,x).equals("."))
            {
                s = swap(s, x-1, x);
                x += 1;
            }
        }
        if ((s.substring(x,x+1).equals(">")) || (s.substring(x,x+1).equals("E")))
        {
            if (s.substring(x-1,x).equals("."))
            {
                s = swap(s, x-1, x);
            }
            return s;
        }
        return s;
    }
    public static String right(int x, String state)
    {
        if (x % 6 >= 5)
            return state;
        String s = state;
        if ((s.substring(x,x+1).equals(">")) || (s.substring(x,x+1).equals("E")))
        {
            if (s.substring(x+1,x+2).equals("."))
            {
                s = swap(s, x, x+1);
                x -= 1;
            }
        }
        if ((s.substring(x,x+1).equals("L")))
        {
            if (s.substring(x+1,x+2).equals("."))
            {
                s = swap(s, x, x+1);
                x -= 1;
            }
        }
        if ((s.substring(x,x+1).equals("<")) || (s.substring(x,x+1).equals("S")))
        {
            if (s.substring(x+1,x+2).equals("."))
            {
                s = swap(s, x, x+1);
            }
            return s;
        }
        return s;
    }
    public static String up(int x, String state)
    {
        if (x <= 5)
            return state;
        String s = state;
        if ((s.substring(x,x+1).equals("^")))
        {
            if (s.substring(x-6,x-5).equals("."))
            {
                s = swap(s, x-6, x);
                x += 6;
            }
        }
        if ((s.substring(x,x+1).equals("U")))
        {
            if (s.substring(x-6,x-5).equals("."))
            {
                s = swap(s, x-6, x);
                x += 6;
            }
        }
        if ((s.substring(x,x+1).equals("v")))
        {
            if (s.substring(x-6,x-5).equals("."))
            {
                s = swap(s, x-6, x);
            }
            return s;
        }
        return s;
    }
    public static String down(int x, String state)
    {
        if (x >= 30)
            return state;
        String s = state;
        if ((s.substring(x,x+1).equals("v")))
        {
            if (s.substring(x+6,x+7).equals("."))
            {
                s = swap(s, x, x+6);
                x -= 6;
            }
        }
        if ((s.substring(x,x+1).equals("U")))
        {
            if (s.substring(x+6,x+7).equals("."))
            {
                s = swap(s, x, x+6);
                x -= 6;
            }
        }
        if ((s.substring(x,x+1).equals("^")))
        {
            if (s.substring(x+6,x+7).equals("."))
            {
                s = swap(s, x, x+6);
            }
            return s;
        }
        return s;
    }
    public static String swap(String state, int i, int j)
    {
        StringBuilder br = new StringBuilder(state);
        br.setCharAt(i, state.charAt(j));
        br.setCharAt(j, state.charAt(i));
        return br.toString();
    }
}
