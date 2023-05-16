import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BEKHService } from '../bekh.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit{
  firstname="";
  lastname="";
  email="";
  phonenumber="";
  password="";
  condition=false;

  constructor(private service:BEKHService, private router:Router){}

  ngOnInit(): void {

  }

  signup(){

    var newUser={'firstname':this.firstname,
                  'lastname':this.lastname,
                  'email':this.email,
                  'phone':this.phonenumber,
                  'password' :this.password};
                  
    this.service.signup(newUser).subscribe(
      (res)=>{
        this.firstname="";
        this.lastname="";
        this.email="";
        this.phonenumber="";
        this.password="";
        this.condition=true;
        console.log("successfully registered");
        this.router.navigate(['/login']);
      },
      (err)=>{
        console.log(err.message);
        
      }
    )   
    
  }

}
