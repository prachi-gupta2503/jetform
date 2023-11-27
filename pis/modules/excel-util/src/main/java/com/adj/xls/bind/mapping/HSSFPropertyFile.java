package com.adj.xls.bind.mapping;

import com.adj.xls.bind.PropertyUnmarshaller;
import com.adj.xls.exception.PoijiException;
import com.adj.xls.option.PoijiOptions;

import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;
import org.apache.poi.poifs.filesystem.DocumentFactoryHelper;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by adj on 24.05.2020
 */
public final class HSSFPropertyFile implements PropertyUnmarshaller {

    private File file;
    private PoijiOptions options;

    HSSFPropertyFile(File file, PoijiOptions options) {
        this.file = file;
        this.options = options;
    }

    @Override
    public <T> T unmarshal(Class<T> type) {
        if (options.getPassword() != null) {
            return returnFromEncryptedFile(type);
        }
        return returnFromExcelFile(type);
    }

    @Override
    public <T> T returnFromExcelFile(Class<T> type) {
        try (OPCPackage open = OPCPackage.open(file, PackageAccess.READ)) {
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(open);
            PropertyHandler propertyHandler = new PropertyHandler();
            T ret = propertyHandler.unmarshal(type, xssfWorkbook.getProperties());
            xssfWorkbook.close();
            return ret;
        } catch (IOException | OpenXML4JException e) {
            throw new PoijiException("Problem occurred while reading data", e);
        }
    }

    @Override
    public <T> T returnFromEncryptedFile(Class<T> type) {
        try (POIFSFileSystem fs = new POIFSFileSystem(file, true)) {
            InputStream stream = DocumentFactoryHelper.getDecryptedStream(fs, options.getPassword());
            try (OPCPackage open = OPCPackage.open(stream)) {
                XSSFWorkbook xssfWorkbook = new XSSFWorkbook(open);
                PropertyHandler propertyHandler = new PropertyHandler();
                T ret =  propertyHandler.unmarshal(type, xssfWorkbook.getProperties());
                xssfWorkbook.close();
                return ret;
            } catch (IOException | OpenXML4JException e) {
                IOUtils.closeQuietly(fs);
                throw new PoijiException("Problem occurred while reading data", e);
            }
        } catch (IOException e) {
            throw new PoijiException("Problem occurred while reading data", e);
        }
    }
}
