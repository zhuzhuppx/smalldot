import X from "xlsx";
import FileSaver from "file-saver";
class ExcelUtil {
  constructor() {}
  handleExcelFile(f, callback) {
    let reader = new FileReader();
    let name = f.name;
    try {
      reader.readAsBinaryString(f);
      reader.onload = function(e) {
        let wb;
        try {
          let data = e.target.result;
          wb = X.read(data, {
            type: "binary"
          });
        } catch (e) {}
        callback(wb);
      };
    } catch (e) {}
  }
  to_json(workbook) {
    let result = {};
    workbook.SheetNames.forEach(function(sheetName) {
      let roa = X.utils.sheet_to_row_object_array(workbook.Sheets[sheetName]);
      if (roa.length > 0) {
        result[sheetName] = roa;
      }
    });
    return result;
  }
  gen_json(
    workbook,
    sheetname,
    shiftrange = {
      s: {
        c: 0,
        r: 2
      },
      e: {
        c: 0,
        r: 0
      }
    }
  ) {
    let me = this;
    let result = new Array();
    if (!sheetname) {
      sheetname = workbook.SheetNames[0];
    }
    let sheet = workbook.Sheets[sheetname];
    if (sheet == null) {
      console.log("Excel sheet没有找到呀，[" + sheetname + "] 在哪里？");
      return null;
    }
    let r = X.utils.decode_range(sheet["!ref"]);
    let cols = [];
    for (let C = r.s.c + shiftrange.s.c; C <= r.e.c + shiftrange.e.c; ++C)
      cols[C] = X.utils.encode_col(C);
    for (let R = r.s.r + shiftrange.s.r; R <= r.e.r + shiftrange.e.r; ++R) {
      let row = {};
      let rr = X.utils.encode_row(R);
      for (let C = r.s.c + shiftrange.s.c; C <= r.e.c + shiftrange.e.c; ++C) {
        let v = sheet[cols[C] + rr];
        let value = v !== undefined ? "" + X.utils.format_cell(v) : "";
        row[cols[C]] = value;
      }
      result.push(row);
    }
    let result2 = new Array();
    result2.push(sheet["!merges"]);
    let obj = new Array();
    obj[0] = result;
    obj[1] = result2;
    return obj;
  }
  s2ab(s) {
    if (typeof ArrayBuffer !== "undefined") {
      let buf = new ArrayBuffer(s.length);
      let view = new Uint8Array(buf);
      for (let i = 0; i != s.length; ++i) view[i] = s.charCodeAt(i) & 0xff;
      return buf;
    } else {
      let buf = new Array(s.length);
      for (let i = 0; i != s.length; ++i) buf[i] = s.charCodeAt(i) & 0xff;
      return buf;
    }
  }
  export_json_to_excel(type, fn, json) {
    let sheet = X.utils.json_to_sheet(json);
    let wb = X.utils.book_new();
    X.utils.book_append_sheet(wb, sheet, "sheet");
    let wbout = X.write(wb, {
      bookType: type,
      bookSST: true,
      type: "binary"
    });
    let fname = (fn || "test") + "." + type;
    try {
      FileSaver.saveAs(
        new Blob([this.s2ab(wbout)], {
          type: "application/octet-stream"
        }),
        fname
      );
    } catch (e) {
      if (typeof console != "undefined") console.log(e, wbout);
    }
    return wbout;
  }
  processJsonArray(f, callback) {
    this.handleExcelFile(f, wb => {
      let json = this.to_json(wb);
      callback(json);
    });
  }
  processOrignArray(f, callback) {
    this.handleExcelFile(f, wb => {
      let json = this.gen_json(wb);
      callback(json);
    });
  }
}
export default new ExcelUtil();
