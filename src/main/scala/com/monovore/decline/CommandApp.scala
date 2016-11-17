package com.monovore.decline

class CommandApp(name: String, header: String, main: Opts[Unit]) {

  def main(args: Array[String]): Unit = {
    val command = Command(name, header, Opts.help orElse main)
    Parse(args.toList, command.options)
      .valueOr { errors =>
        errors.foreach(System.err.println)
        System.err.println(Help.render(command))
      }
  }
}
