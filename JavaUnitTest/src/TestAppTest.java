import java.io.FileInputStream;
import java.io.IOException;

import org.junit.Test;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class TestAppTest
{
	@Test
	public void testSax()
	{
		try
		{
			final XMLReader xr = XMLReaderFactory.createXMLReader();

			xr.setContentHandler(new ContentHandler() {

				@Override
				public void setDocumentLocator(final Locator locator)
				{
					// TODO Auto-generated method stub

				}

				@Override
				public void startDocument() throws SAXException
				{
					// TODO Auto-generated method stub
					System.out.println("startDocument.");
				}

				@Override
				public void endDocument() throws SAXException
				{
					// TODO Auto-generated method stub

				}

				@Override
				public void startPrefixMapping(final String prefix, final String uri) throws SAXException
				{
					// TODO Auto-generated method stub

				}

				@Override
				public void endPrefixMapping(final String prefix) throws SAXException
				{
					// TODO Auto-generated method stub

				}

				@Override
				public void startElement(final String uri, final String localName, final String qName, final Attributes atts) throws SAXException
				{
					// TODO Auto-generated method stub
					System.out.println("startElement:" + uri + "/" + localName + "/" + qName + "/" + atts.toString());
				}

				@Override
				public void endElement(final String uri, final String localName, final String qName) throws SAXException
				{
					// TODO Auto-generated method stub
					System.out.println("endElements:" + uri + "/" + localName + "/" + qName);
				}

				@Override
				public void characters(final char[] ch, final int start, final int length) throws SAXException
				{
					// TODO Auto-generated method stub

				}

				@Override
				public void ignorableWhitespace(final char[] ch, final int start, final int length) throws SAXException
				{
					// TODO Auto-generated method stub

				}

				@Override
				public void processingInstruction(final String target, final String data) throws SAXException
				{
					// TODO Auto-generated method stub

				}

				@Override
				public void skippedEntity(final String name) throws SAXException
				{
					// TODO Auto-generated method stub

				}

			});

			try
			{
				xr.parse(new InputSource(new FileInputStream("./conf/TestXml.xml")));
			}
			catch (final IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		catch (final SAXException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
