import { Component, OnInit } from '@angular/core';
import { BEKHService } from '../bekh.service';

@Component({
  selector: 'app-create-event',
  templateUrl: './create-event.component.html',
  styleUrls: ['./create-event.component.css']
})
export class CreateEventComponent implements OnInit{

  title=""
  host="";
  address="";
  date:any;
  time:any;
  description="";
  condition=false;

  constructor(private service:BEKHService){}
  ngOnInit(): void { 
  }

  register(){

    var event={'title':this.title,
                'host':this.host,
                'address':this.address,
                'event_date':this.date,
                'event_time':this.time,
                'description':this.description};
    
    this.service.createEvent(event).subscribe(
      (res)=>{
        console.log("successfully registered");
        this.condition=true;
        this.title=""
        this.host="";
        this.address="";
        this.date={};
        this.time={};
        this.description="";
        this.condition=false;
      },
      (err)=>{
        console.log(err.message);
        
      }
    )   
    
  }

}
