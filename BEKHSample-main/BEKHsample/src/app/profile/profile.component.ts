import { Component, OnInit } from '@angular/core';
import { BEKHService } from '../bekh.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit{

  events:any;
  businesses:any;

  constructor(private service:BEKHService){}

  ngOnInit(): void {
    this.load()
  }

  load(){
    this.getBusiness();
    this.getEvents();
  }

  getEvents(){
    this.service.getEvents().subscribe(
      (res)=>{
        
        this.events=res;
        console.log(this.events);
      },
      (err)=>{
        console.log(err.message);
        
      }
    )

  }

  getBusiness(){
    this.service.getBusinesses().subscribe(
      (res)=>{
        
        this.businesses=res;
        console.log(this.businesses);
      },
      (err)=>{
        console.log(err.message);
        
      }
    )

  }



}
