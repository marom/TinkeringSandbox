import {Component, OnInit} from '@angular/core';
import {LoginService} from "../../services/login.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private model = {'username':'', 'password':''};
  private currentUserName;

  constructor (private loginService: LoginService){
    this.currentUserName = localStorage.getItem('currentUserName');
  }

  ngOnInit() {
  }

  onSubmit() {
   this.loginService.sendCredential(this.model).subscribe(
      data => {
       // console.log('XdataX:'+data);
       // console.log('Data log 2:' + JSON.parse(JSON.stringify(data)).body);
        //localStorage.setItem('token', JSON.stringify(data));
        // this.loginService.sendToken(localStorage.getItem('token')).subscribe(
        //   data => {
        //     this.currentUserName=this.model.username;
        //     localStorage.setItem('currentUserName', this.model.username);
        //     this.model.username='';
        //     this.model.password='';
        //   },
        //   error => console.log(error)
        // );
      },
      error => console.log(error)
    );
  }
}
