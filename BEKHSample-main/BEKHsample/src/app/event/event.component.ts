import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BEKHService } from '../bekh.service';

@Component({
  selector: 'app-event',
  templateUrl: './event.component.html',
  styleUrls: ['./event.component.css']
})
export class EventComponent implements OnInit{

  eventId="";
  event:any;

  constructor(private service:BEKHService,private route:ActivatedRoute){}

  ngOnInit(): void {
    this.route.params.subscribe( params => {
      this.eventId=params["eId"];    
      console.log(this.eventId);
      
    } );

    this.getEvent();
    
  }

  getEvent(){
    this.service.getEvent(this.eventId).subscribe(
      (res)=>{
        this.event=res;
        console.log(this.event);
        
      },
      (err)=>{
        console.log(err.message);
        
      }
    )
  }
}
