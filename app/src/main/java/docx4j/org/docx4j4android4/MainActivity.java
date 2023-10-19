package docx4j.org.docx4j4android4;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.sun.xml.bind.v2.runtime.JAXBContextImpl;

import org.docx4j.XmlUtils;
import org.docx4j.convert.out.html.HtmlExporterNonXSLT;
import org.docx4j.jaxb.Context;
import org.docx4j.jaxb.XPathBinderAssociationIsPartialException;
import org.docx4j.model.images.ConversionImageHandler;
import org.docx4j.openpackaging.exceptions.InvalidFormatException;
import org.docx4j.openpackaging.io.LoadFromZipNG;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.wml.Document;

import javax.xml.bind.JAXBException;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        try {
            System.out.println("about to create package");

        try {

            File dbFile = getDatabasePath(DATABASE_NAME);
            File source = new File(Environment.getExternalStorageDirectory() + "/Documents");
                source.mkdirs();
                File file = new File(source, "doc4jtest.docx");
                if (!file.exists()) {
                    System.out.println(source);
                    file.createNewFile();
                    Toast.makeText(getApplicationContext(), "creating document", Toast.LENGTH_SHORT).show();
                }try{
                WordprocessingMLPackage wordPackage = WordprocessingMLPackage.createPackage();
                MainDocumentPart mainDocumentPart = wordPackage.getMainDocumentPart();
                mainDocumentPart.addStyledParagraphOfText("Title", "Hello World!");
                mainDocumentPart.addParagraphOfText("Welcome To Baeldung");
                wordPackage.save(file);
            }catch (Exception e){
                    e.printStackTrace();
            }
            System.out.println("document created successfully!");
            Toast.makeText(this,"Document filled successfully", Toast.LENGTH_SHORT).show();
        } catch (Exception e){
            Toast.makeText(this, "Error: Unable to create document", Toast.LENGTH_SHORT).show();
        }
    }
        
            try {
                Object o = XmlUtils.unmarshalString(XML, Context.jc);
                System.out.println(o.getClass().getName());
            } catch (JAXBException e) {
                e.printStackTrace();
            }

            // Test XPath works
            try {
                java.util.List<Object> results = w.getMainDocumentPart().getJAXBNodesViaXPath("//w:t", false);
                System.out.println("Xpath result count:" + results.size());
            } catch (JAXBException e) {
                e.printStackTrace();
            } catch (XPathBinderAssociationIsPartialException e) {
                e.printStackTrace();
            }

            System.out.println("done!");

        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
