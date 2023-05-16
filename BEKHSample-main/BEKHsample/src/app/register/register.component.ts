import { Component, OnInit } from '@angular/core';
import { BEKHService } from '../bekh.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit{
  busName=""
  name="";
  email="";
  phonenumber="";
  address="";
  ownership="";
  website="";
  description="";
  condition=false;

  constructor(private service:BEKHService){}
  ngOnInit(): void {
  }

  register(){
    var newBusiness={'business_name':this.busName,
                      'owner_name':this.name,
                      'email':this.email,
                      'phone':this.phonenumber,
                      'address':this.address,
                      'ownership':this.ownership,
                      'website': this.website,
                      'description': this.description};

    this.service.registerBusiness(newBusiness).subscribe(
      (res)=>{
        this.busName=""
        this.name="";
        this.email="";
        this.phonenumber="";
        this.address="";
        this.ownership="";
        this.website="";
        this.description="";
        this.condition=true;
        console.log("successfully registered");
        
      },
      (err)=>{
        console.log(err.message);
        
      }
    )   

  }

}
