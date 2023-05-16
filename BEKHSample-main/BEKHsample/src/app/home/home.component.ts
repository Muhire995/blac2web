import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BEKHService } from '../bekh.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit{
  events:any
  constructor(private service:BEKHService, private router:Router){}

  
  ngOnInit(): void {
    this.getEvents();
  }

  getEvents(){
    this.service.getUpEvents().subscribe(
      (res)=>{
        this.events=res;
      },
      (err)=>{
        console.log(err.message);
      }
    )
  }

}
