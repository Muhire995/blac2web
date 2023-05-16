import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { BEKHService } from '../bekh.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{
  
  email="";
  password=""

  constructor(private service:BEKHService, private router:Router){}
  ngOnInit(): void {
  }

  signin(){

    var credential={'email':this.email,
                    'password': this.password};
    
    this.service.login(credential).subscribe(
      (res)=>{
        console.log("successfully loged in");
        console.log(res);
        this.router.navigate(['/profile/:'+res]);
        
      },
      (err)=>{
        console.log(err.message);
        
      }
    )   
  }
  

}
