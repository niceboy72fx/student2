import React, { useEffect, useState } from "react";
import TextField from "@mui/material/TextField";
import Button from "@mui/material/Button";
import "./MainStyle.css";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import Paper from "@mui/material/Paper";
import axios from "axios";
import { maxWidth } from "@mui/system";



const Main = () => {
  const [data, setData] = useState([]);

  useEffect(() => {
    LoadAllData();
  }, []);

  const LoadAllData = async () => {
    return await axios
      .get("http://localhost:8080/student")
      .then((Response) => setData(Response.data))
      .catch((err) => console.log(Response));
    console.log(Response);
  };

  const FindData = async () => {
    return await axios
      .get("http://localhost:8080/student/getData/?id={value}")
      .then((Response) => setData(Response.data))
      .catch((err) => console.log(Response));
      console.log(Response);
  };

  

  return (
    <div>
      <div className="boxing">
        <TextField placeholder="Tìm theo tên học sinh" id="NameStudent" />
        <TextField placeholder="Tìm theo mã học sinh" id="IdStudent" />
        <Button variant="contained" size="large">
          Tìm kiếm
        </Button>
      </div>

      <div className="Data">
        <TableContainer >
          <Table
            x={{ minWidth: 700,maxWidth:1000}}
            aria-label="customized table"
            size="large"
          >
            <TableHead>
              <TableBody >
                <TableCell align="center">Họ và tên</TableCell>
                <TableCell align="center">Mã học sinh</TableCell>
                <TableCell align="center">Trường</TableCell>
                <TableCell align="center">Lớp</TableCell>
                <TableCell align="center">Ngày sinh</TableCell>
                <TableCell align="center">Nơi sinh</TableCell>
                <TableCell align="center">Dân tộc</TableCell>
                <TableCell align="center">Hộ khẩu thường trú</TableCell>
                <TableCell align="center">Điện thoại liên hệ</TableCell>
                <TableCell align="center">Tổng điểm sơ tuyển</TableCell>
                <TableCell align="center">Ghi chú</TableCell>
              </TableBody>

              {data.length === 0 ? (
                <TableBody>
                  <tr>
                    <td> Không có trong danh sách tuyển sinh</td>
                  </tr>
                </TableBody>
              ) : (
                data.map((item, index) => (
                  <TableBody>
                    <TableCell>{item.name}</TableCell>
                    <TableCell>{item.idStudent}</TableCell>
                    <TableCell>{item.school}</TableCell>
                    <TableCell>{item.grade}</TableCell>
                    <TableCell>{item.birthDate}</TableCell>
                    <TableCell>{item.province}</TableCell>
                    <TableCell>{item.dan_toc}</TableCell>
                    <TableCell>{item.address_live}</TableCell>
                    <TableCell>{item.phone_num}</TableCell>
                    <TableCell>{item.totalPoint}</TableCell>
                    <TableCell>{item.wnote}</TableCell>
                  </TableBody>
                ))
              )}
            </TableHead>
          </Table>
        </TableContainer>
      </div>
      <script crossorigin src="http://localhost:8080/student"></script>
    </div>
  );
};

export default Main;
