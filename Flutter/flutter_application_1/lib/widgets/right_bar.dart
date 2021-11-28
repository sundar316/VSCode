import 'package:flutter_application_1/constants/app_constants.dart';
import 'package:flutter/material.dart';

class LeftBar extends StatelessWidget{
  final double barWidth;

  const LeftBar({Key? key, required this.barWidth}):super(key:key);

  @override
  Widget build(BuildContext context){
    return Row(
      mainAxisAlignment: MainAxisAlignment.start,
      children: [
        Container(
          height: 25,
          decoration: BoxDecoration(
            borderRadius: const BorderRadius.only(
              topLeft: Radius.circular(20),
              bottomLeft: Radius.circular(20),
            ),
          color: accentHexColor),
        )
      ],
    );
  }
}